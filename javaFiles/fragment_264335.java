public class YourServerApplicationConfig implements ServerApplicationConfig {

    @Override
    public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> scannedClasses) {
        Set<ServerEndpointConfig> configs = new HashSet<>();
        configs.add(ServerEndpointConfig.Builder.create(YourEndpoint.class, "/yourPath").build());
        return configs;
    }

    @Override
    public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scannedClasses) {
        return Collections.emptySet();
    }

}