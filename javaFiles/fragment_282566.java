abstract class AbstractTransformingDecodingInterceptor
        implements Interceptor {

    protected abstract InputStream transformInputStream(InputStream inputStream)
            throws IOException;

    @Override
    @SuppressWarnings("resource")
    public final Response intercept(final Chain chain)
            throws IOException {
        final Request request = chain.request();
        final Response response = chain.proceed(request);
        final ResponseBody body = response.body();
        return response.newBuilder()
                .body(ResponseBody.create(
                        body.contentType(),
                        body.contentLength(),
                        Okio.buffer(Okio.source(transformInputStream(body.byteStream())))
                ))
                .build();
    }

}