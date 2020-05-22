interface IService {

    @GET("/")
    Call<String> get();

}