cardViewHolder.btnStart.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mOnItemClickListener.onItemClick(v, position);
        }
    });