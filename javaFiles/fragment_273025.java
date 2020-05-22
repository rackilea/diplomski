@Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.MoviePopularity.setText(String.valueOf(mMoviesItems.get(position).getPopularity()));
        Picasso.with(this.context).load(mMoviesItems.get(position).getFullPosterPath()).into(holder.MoviePoster);
        holder.MovieName.setText(String.valueOf(mMoviesItems.get(position).getName()));
    }