private OkHttpClient httpClient;

@Inject
void onPostInject() {
    httpClient =
        new OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor(httpClientInterceptor)
        .build();
}