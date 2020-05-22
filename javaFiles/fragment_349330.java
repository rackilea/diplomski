@Module
abstract class NetworkModule {

    @Provides
    @Singleton
    static TokenStore provideTokenStore(TokenStoreImpl tokenStore) {
        return tokenStore;
    }

    @Provides
    @Singleton
    static OkHttpClient provideOkHttpClient(AuthInterceptor authInterceptor) {
        // Add the interceptor to OkHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(authInterceptor);
        return builder.build();
    }

    @Provides
    @Singleton
    static Retrofit providesRetrofit(Application application, OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(application.getString(R.string.endpoint_url))
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    @Provides
    @Singleton // needs to be consistent with the component scope
    static PetshackApi providesPetshackApiInterface(Retrofit retrofit) {
        return retrofit.create(PetshackApi.class);
    }
}

interface TokenStore {
    String getToken();
    void setToken(String token);
}

@Singleton
class TokenStoreImpl implements TokenStore {

    String token;

    @Inject
    public TokenStoreImpl() { }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public void setToken(String token) {
        this.token = token;
    }
}

@Singleton
class AuthInterceptor implements Interceptor {

    private final TokenStore tokenStore;

    @Inject
    public AuthInterceptor(TokenStore tokenStore) {
        this.tokenStore = tokenStore;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request newRequest = chain.request()
                .newBuilder().addHeader("authorization", "Bearer " + tokenStore.getToken()).build();
        return chain.proceed(newRequest);
    }
}