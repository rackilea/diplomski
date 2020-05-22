isMe = customer_id.equals(message.getUserId()); 
    isProducer = message.getUserId().equals(producer_id);

    if (isMe) {
        holder.imageRight.setVisibility(View.VISIBLE);
        holder.imageLeft.setVisibility(View.GONE);
        holder.body.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);

    } else {
        holder.imageLeft.setVisibility(View.VISIBLE);
        holder.imageRight.setVisibility(View.GONE);
        holder.body.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
    }

    holder.body.setText(message.getBody());
    if (isProducer) {
        holder.body.setTypeface(null, Typeface.BOLD);
    } else {
        holder.body.setTypeface(null, Typeface.NORMAL); // Or anything else
     }