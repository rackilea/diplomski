public class ConfigBinder extends AbstractModule {

    private final String CONFIG_PATH = "config";

    @Override
    protected void configure() {
        this.bind(ConfigReader.class).to(ConfigReaderImpl.class).in(Scopes.NO_SCOPE);
        this.bindConfig(Vertx.currentContext().config(), this.CONFIG_PATH);
    }

    private void bindConfig(JsonObject config, String path) {
        this.bind(JsonObject.class).annotatedWith(Names.named(path)).toInstance(config);
    }

}