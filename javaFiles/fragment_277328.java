public interface MyApi {
    @POST("register")
    @HEADERS("@: NoAuth")
    Call<RegisterResponse> register(@Body RegisterRequest data);

    @GET("user/{userId}")
    Call<GetUserResponse> getUser(@Path("userId") String userId);
}