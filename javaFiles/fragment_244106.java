AsyncTask asyncTask = new AsyncTask<Void, Void, Void>() {

    @Override
    protected Void doInBackground(Void... params) {
        mMovieDto = mDataSource.getPopularMovies();
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        fillList();
    }
};
asyncTask.execute();