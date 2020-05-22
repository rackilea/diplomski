public class MyWebService extends ResourceConfig {
    public MyWebService() {
        register(EncodingFilter.class);
        register(GZipEncoder.class);
        register(DeflateEncoder.class);

        ...

        property(ServerProperties.OUTBOUND_CONTENT_LENGTH_BUFFER, 32768);

    }
}