public interface Api {

    String BASE_URL = "https://api.themoviedb.org/3/discover/";

    @GET("movie")
    Call<MovieItems> getMovies(@Query("api_key") String apiKey, @Query("language")String language);

}