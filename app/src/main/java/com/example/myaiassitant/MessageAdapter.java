package com.example.myaiassitant;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myaiassitant.databinding.ItemChatBinding;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {
    List<Message> messageList;

    public MessageAdapter(List<Message> messageList) {
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat, null);
        return new MessageViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        Message message = this.messageList.get(position);

        if(message.sendBy.equals(Message.SENT_BY_ME)) {
            holder.rightTextView.setText(message.message);
            holder.leftLinear.setVisibility(View.GONE);
            holder.rightLinear.setVisibility(View.VISIBLE);
        } else {
            holder.leftTextView.setText(message.message);
            holder.rightLinear.setVisibility(View.GONE);
            holder.leftLinear.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return this.messageList.size();
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {
        LinearLayout leftLinear, rightLinear;
        TextView leftTextView, rightTextView;


        public MessageViewHolder(@NonNull View view) {
            super(view);
            leftLinear = view.findViewById(R.id.linear_left_chat);
            rightLinear = view.findViewById(R.id.linear_right_chat);
            leftTextView = view.findViewById(R.id.tv_left_chat);
            rightTextView = view.findViewById(R.id.tv_right_chat);

        }
    }



}

