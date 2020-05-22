public class ApiClient {


 public static final String BASE_URL = "https://api.coinmarketcap.com/v1/";
 public static Retrofit retrofit = null;

 public static Retrofit getApiClient() {

  if (retrofit == null) {


   retrofit = new Retrofit.Builder()
                  .baseUrl(BASE_URL)
                  .addConverterFactory(GsonConverterFactory.create())
                  .build();

  }
  return retrofit;

 }
}