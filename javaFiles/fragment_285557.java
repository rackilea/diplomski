public class AppConfig extends PackagesResourceConfig{

    public AppConfig() {
        getProperties().put(JSONConfiguration.FEATURE_POJO_MAPPING, true);
    }
}