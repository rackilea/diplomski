final class Base64DecodingInterceptor
        extends AbstractTransformingDecodingInterceptor {

    private static final Interceptor base64DecodingInterceptor = new Base64DecodingInterceptor();

    private Base64DecodingInterceptor() {
    }

    static Interceptor getBase64DecodingInterceptor() {
        return base64DecodingInterceptor;
    }

    @Override
    protected InputStream transformInputStream(final InputStream inputStream) {
        return BaseEncoding.base64().decodingStream(new InputStreamReader(inputStream));
    }

}