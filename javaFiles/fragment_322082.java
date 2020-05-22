holder.mPinterestButton = ((PinItButton) holder.content.findViewById(R.id.pin_it));
    holder.mPinterestButton.setImageUrl("http://placekitten.com/400/300");
    holder.mPinterestButton.setUrl("http://placekitten.com"); // optional
    holder.mPinterestButton.setDescription("A place kitten!"); // optional
    holder.pinterestButton = ((Button) holder.content.findViewById(R.id.car_info_comment_pinterest));
    holder.pinterestButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            holder.mPinterestButton.performClick();
        }
    });