import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import java.util.concurrent.TimeUnit;    
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class UrlModule {
    private String url;

    public UrlModule(String url) {
        this.url = url;
    }

    @Provides
    @PerUrl
    OkHttpClient provideOkhttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    String provideUrl() {
        return url;
    }

    @Provides
    @PerUrl
    Retrofit provideRetrofit(String baseURL, OkHttpClient client) {

        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }


    @Provides
    RestApi provideApiService(Retrofit retrofit) {
        return retrofit.create(RestApi.class);
    }
}