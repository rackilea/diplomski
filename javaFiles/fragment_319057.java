public class JerseyApplication extends ResourceConfig {
    public JerseyApplication() {
        packages(...);
        getProviderClasses().add(JacksonJsonProvider.class);
        getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
    }
}