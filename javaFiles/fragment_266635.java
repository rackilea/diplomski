public interface APIService {

    @POST("http://api.nuuneoi.com/special/user/list")
    Call<Users> loadSpecialUsers();

}