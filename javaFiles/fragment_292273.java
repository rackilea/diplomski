myViewHolder.button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           itemClickCallback.onClicked(position);
        }
    });