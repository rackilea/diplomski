final class GzipDecodingInterceptor
        extends AbstractTransformingDecodingInterceptor {

    private static final Interceptor gzipDecodingInterceptor = new GzipDecodingInterceptor();

    private GzipDecodingInterceptor() {
    }

    static Interceptor getGzipDecodingInterceptor() {
        return gzipDecodingInterceptor;
    }

    @Override
    protected InputStream transformInputStream(final InputStream inputStream)
            throws IOException {
        return new GZIPInputStream(inputStream);
    }

}