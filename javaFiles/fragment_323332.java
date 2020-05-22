public class PropertySourcesAdderBean implements InitializingBean,
        ApplicationContextAware {

    private Properties properties;

    private ApplicationContext applicationContext;

    public PropertySourcesAdderBean() {

    }

    public void afterPropertiesSet() throws Exception {

    PropertiesPropertySource propertySource = new PropertiesPropertySource(
            "helloWorldProps", this.properties);

    ConfigurableEnvironment environment = (ConfigurableEnvironment) this.applicationContext
            .getEnvironment();

    environment.getPropertySources().addFirst(propertySource);

    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {

        this.applicationContext = applicationContext;

    }

}