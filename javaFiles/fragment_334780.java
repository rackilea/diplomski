if(isMe) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.message_right, parent, false);
        }
        else{
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.message_left, parent, false);
        }
    }