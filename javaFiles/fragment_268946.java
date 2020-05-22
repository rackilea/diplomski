public class AppConfig extends ResourceConfig {
    public AppConfig() {
        ...
        property(ServerProperties.OUTBOUND_CONTENT_LENGTH_BUFFER, 0);
    }
}