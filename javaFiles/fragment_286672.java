private static final Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = new Interceptor() {
    @Override public okhttp3.Response intercept(Chain chain) throws IOException {
        okhttp3.Response originalResponse = chain.proceed(chain.request());

        if (validate(originalResponse.headers()) {
            return originalResponse.newBuilder()
                   .body(null) //remove the body, stupid
                   .build();
        }
        return originalResponse;
    }
};