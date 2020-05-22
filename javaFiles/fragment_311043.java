public class ConfigReaderImpl implements ConfigReader {

    private final JsonObject config;

    @Inject
    private ConfigReaderImpl(@Named("config") final JsonObject config) {
        this.config = config;
    }

    @Override
    public JsonObject getConfig() {
        return this.config;
    }

}