@Override
public void onBindViewHolder(ViewHolder Vholder,final int position){
    Vholder.img.setImageResource(imageid[position]);
    Vholder.tx1.setText(names[position]);

    Vholder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    });
    Vholder.likeButton.setOnLikeListener(new OnLikeListener() {
    @Override
    public void liked(LikeButton likeButton) {

        //Logic
    }
    @Override
    public void unLiked(LikeButton likeButton) {

    }
    });
    }