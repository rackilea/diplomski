holder.album_img.setOnLongClickListener(new OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            holder.rmv_img.setVisibility(View.VISIBLE);
            return true;
        }
    });