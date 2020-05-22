@Override
public void onBindViewHolder(NtindaCinemaViewHolders holder, int position) {
    final ItemObjects feedItem = itemList.get(position);

    holder.root.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(NtindaCinemaAdapter.this.context, MovieScrollingActivity.class);
            intent.putExtra(NtindaCinemaViewHolders.KEY_SYNOPSIS, feedItem.getSynopsis());

            c.startActivity(intent);
        }
    });

    //Download image using picasso library
    Picasso.with(context).load(url+feedItem.getPhoto())
            .error(R.drawable.placeholder).
            resize(500,500)
            .placeholder(R.drawable.placeholder)
            .into(holder.moviepic);

    holder.moviename.setText(feedItem.getMovieName());
}