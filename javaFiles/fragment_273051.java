@Singleton
@Provides
RestClient provideRestClient(OkHttpClient okhttpclient) {
    return RestClient(okhttpClient);
}

@Provides
@Singleton
Retrofit provideRetrofit(OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory) {
    return new Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://example.com")
        .client(okHttpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();
}

@Singleton // marked as singleton
@Provides
OkHttpClient provideOkHttpClient() {
    return new OkHttpClient.Builder().build();
}