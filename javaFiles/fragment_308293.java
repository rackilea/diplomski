@Bean
public ResourceConfig getResourceConfig(JerseyProperties jerseyProperties) {
    return new JerseyConfig(jerseyProperties);
}
...
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig(JerseyProperties jerseyProperties) {
        register(HelloResource.class);
        register(new EndpointLoggingListener(jerseyProperties.getApplicationPath()));
    }
}