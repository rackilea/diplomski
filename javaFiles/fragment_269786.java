import retrofit2.Call;
import retrofit2.http.GET;

public interface FooApiInterface {

    /* pass POJO class to Call<> */

    @GET("request/url")
    Call<Foo> getFoo(/* parameters for the request if there any */);

    /* other api calls here */
}