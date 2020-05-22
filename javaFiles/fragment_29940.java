public interface ApiService {
    // You don't need to explicitly pass ``key`` and ``q``. These query params will be added by retrofit automatically.
    @GET("/v1/search.json")
     // return type is List<Weather>
     Call<List<Weather>> getWeather(
            @Query("key") String mKey,
            @Query("q") String mCityName);

}