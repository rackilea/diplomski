holder.kennzeichen.setText(kennzeichen_array[position]);
        holder.hiddenTextView.setText(stadt_array[position]);
        final TextView myHiddenText = holder.hiddenTextView;

        if (shouldBeHidden[position]){
            myHiddenText.setVisibility(View.GONE);
        }
        else{
            myHiddenText.setVisibility(View.VISIBLE);
        }

  holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Log.d("Clicked", String.valueOf(holder.getAdapterPosition()));
        if (myHiddenText.getVisibility()==View.VISIBLE){
            myHiddenText.setVisibility(View.GONE);
            shouldBeHidden[position] = true;
        }
        else{
            myHiddenText.setVisibility(View.VISIBLE);
            shouldBeHidden[position] = false;
        }

    }
});