new Interceptor() {
    Response intercept(Chain chain) throws IOException {
        HttpUrl originalUrl = chain.request().url();
        String query = originalUrl.encodedQuery();
        if (query == null) {
            return chain.proceed(chain.request());
        } else {
            Request.Builder builder = chain.request().newBuilder();
            builder.url(originalUrl.newBuilder()
                .encodedQuery(query.replace('&', ';'))
                .build());
            return chain.proceed(builder.build());
        }
    }
};