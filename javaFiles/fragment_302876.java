viewHolder.itemView.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            onClick.onItemClick(position);
        }
    });