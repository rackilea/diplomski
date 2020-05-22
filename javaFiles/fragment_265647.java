public interface ObjectService {

    @POST("post/example")
    Call<Object > postexemple(@Body Object object);

    @GET("get/example/{id}")
    Call<Object> getexemple(@Path("id") Integer id);

}