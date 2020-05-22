public class MoviesAdapter extends 
RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>{
    List<MovieList> moviesList;
    Context context;
    public MoviesAdapter(Context context, List<MovieList> moviesList){
        this.context = context;
        this.moviesList = moviesList;
    }

    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.grid_movies, viewGroup, false);
        return new MoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder moviesViewHolder, int i) {
        MovieList items = moviesList.get(i);
        String url = "https://image.tmdb.org/t/p/original";
        moviesViewHolder.txt_title_movies.setText(items.getTitle());
        moviesViewHolder.txt_date_movies.setText(items.getReleaseDate());
        moviesViewHolder.txt_description_movies.setText(items.getOverview());
        Glide.with(context)
                .load(url + items.getPosterPath())
                .into(moviesViewHolder.img_movies);
    }

    @Override
    public int getItemCount() {
        return (moviesList != null) ? moviesList.size() : 0;
    }

    public class MoviesViewHolder extends RecyclerView.ViewHolder {
        TextView txt_title_movies, txt_date_movies, txt_description_movies;
        ImageView img_movies;

        public MoviesViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_title_movies = itemView.findViewById(R.id.txt_titlemovie);
            txt_date_movies = itemView.findViewById(R.id.txt_datemovie);
            txt_description_movies = itemView.findViewById(R.id.txt_descriptionmovie);
            img_movies = itemView.findViewById(R.id.img_movie);
        }
    }
}