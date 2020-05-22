public class PropertyResolver implements ApplicationContextInitializer<ConfigurableWebApplicationContext>{

    @Override
    public void initialize(ConfigurableWebApplicationContext ctx) {
        Map<String, Object> modifiedValues = new HashMap<>();
        MutablePropertySources propertySources = ctx.getEnvironment().getPropertySources();
        propertySources.forEach(propertySource -> {
            String propertySourceName = propertySource.getName();
            if (propertySource instanceof MapPropertySource) {
                Arrays.stream(((EnumerablePropertySource) propertySource).getPropertyNames())
                      .forEach(propName -> {
                          String propValue = (String) propertySource.getProperty(propName);
                          // do something
                      });
            }
        });
    }
}