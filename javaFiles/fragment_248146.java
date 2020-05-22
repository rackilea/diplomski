viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          Item item = getItem(getAdapterPosition());
          outsideClickListener.onItemClicked(item);
      }
});