public interface AppApi {
    @GET("path/path")
    Observable<List<PojoItem>> getItemsbyRxJava();


    @GET("path/path")
    Call<List<PojoItem>> getItemsbyRetrofit();
}