Call<PopularMovies> call = movieAPI.getPopularMovies(sortBy, key);
call.enqueue(new Callback<PopularMovies>() {
        @Override
        public void onResponse(Response<PopularMovies> response) {

        }

        @Override
        public void onFailure(Throwable t) {
        }
    });