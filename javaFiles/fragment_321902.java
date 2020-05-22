ViewHolder holder; 
holder.message.setText(message.getMessage());

LayoutParams lp = (LayoutParams) holder.message.getLayoutParams();

    if(message.isMine())
    {
        holder.message.setBackgroundResource(R.drawable.left_grey);
        lp.gravity = Gravity.RIGHT;
    }
    else
    {
        holder.message.setBackgroundResource(R.drawable.right_blue);
        lp.gravity = Gravity.LEFT;
    }