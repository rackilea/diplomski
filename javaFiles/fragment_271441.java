@Override
    protected void onPostExecute(List<Movie> parsedMovies){
        mMoviesList.addAll(parsedMovies);
        // Now I am sure this will work :)
        mAdapter.notifyDataSetChanged(); 
    }