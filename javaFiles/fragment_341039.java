@Module
public class ServiceModule {
    @Provides
    @Singleton
    OkHttp provideOkHttp(Authenticator authenticator) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();
                    Request.Builder builder = request.newBuilder()
                            .addHeader("Accept", "application/json")
                            .addHeader("Connection", "close");

                    request = builder.build();
                    return chain.proceed(request);
                }
            });

        if (BuildConfig.DEBUG) {
            builder.addNetworkInterceptor(new StethoInterceptor());
        }

        // build this authenticator in the same way as all the other dependencies shown here
        builder.authenticator(authenticator);

        return builder.build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttp okHttp) {
        return new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttp)
            .addConverterFactory(MoshiConverterFactory.create())
            .build();
    }

    @Provides
    @Singleton
    Service provideService(Retrofit retrofit) {
        return new ServiceImpl(retrofit);
    }
}