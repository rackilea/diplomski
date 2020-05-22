Pholder.mPlace.setOnLongClickListener(new 
    View.OnLongClickListener() {
        @Override
         public boolean onLongClick(View view) {
             listener.onItemLongPressed(position);
         }
    });