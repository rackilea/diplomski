new OkHttpClient.Builder().addNetworkInterceptor(new Interceptor() {
    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        List<String> customAnnotations = request.headers().values("@");

        // do something with the "custom annotations"

        request = request.newBuilder().removeHeader("@").build();
        return chain.proceed(request);
    }
});