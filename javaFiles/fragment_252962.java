public class Model extends ViewModel {


    private MutableLiveData<List<MovieList>> moviesList;

    public LiveData<List<MovieList>> getMovies() {
        if (moviesList == null){
            moviesList = new MutableLiveData<List<MovieList>>();

            loadMovies();
        }

        return moviesList;
    }

    private void loadMovies() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
     /*Add your api key*/   Call<MovieItems> call = api.getMovies("Your api key","en-US");

        call.enqueue(new Callback<MovieItems>() {
            @Override
            public void onResponse(Call<MovieItems> call, Response<MovieItems> response) {
                moviesList.setValue(response.body().getMovieLists());
            }

            @Override
            public void onFailure(Call<MovieItems> call, Throwable t) {

            }
        });
    }

}