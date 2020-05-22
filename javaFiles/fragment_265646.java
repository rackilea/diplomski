public class RetrofitInicializador {
public RetrofitInitialization() {

String url = "localhost:8080/webservice/";
retrofit = new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(JacksonConverterFactory.create()).build();
}
}