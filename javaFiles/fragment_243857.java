public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    ArrayList<Movie> toSave = mMovieList instanceof ArrayList ?
        (ArrayList<Movie>)mMovieList : new ArrayList<Movie>(mMovieList);
    outState.putParcelableArrayList(MOVIE_KEY, toSave);
}