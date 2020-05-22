@Override
public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
    if (holder instanceof ViewHolderBlank) {

    } else if (holder instanceof ViewHolderOriginal) {
        SeatDetails seatDetails = seatDetailsList.get(position);
        if (seatDetails.isSelected){
            ((ViewHolderOriginal) holder).imageView.setImageBitmap(seatSelect);
        }else{
            ((ViewHolderOriginal) holder).imageView.setImageBitmap(seatIcon);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SeatDetails seatDetails = seatDetailsList.get(position);

                if (seatDetails.isSelected){
                    seatDeselected(position);
                }else{
                    seatSelected(position);
                }
            }
        });
    }
}