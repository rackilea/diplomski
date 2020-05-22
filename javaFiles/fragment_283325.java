public class ApiClient {

private static ApiInterface sApiInterface;

public static ApiInterface getApiClient(Context context) {

    //build the rest adapter
    if (sApiInterface == null) {
        final RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("example.com")
                .build();
        sApiInterface = restAdapter.create(ApiInterface.class);
    }
    return sApiInterface;
}


public interface ApiInterface {

    @GET("/program/{id}")
    void getProgram(@Path("id") int id, RetrofitCallback<Program> callback);

}