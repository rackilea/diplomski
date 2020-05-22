@Configuration
public class PropertiesConfig {

@Bean
public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
    return PropertyLoadHelper.getPropertySourcesPlaceholderConfigurer();
}

public static class PropertyLoadHelper {
    public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer properties = new PropertySourcesPlaceholderConfigurer();
        properties.setLocations(new ClassPathResource[]{
                new ClassPathResource("config/app." + System.getenv("ENV") + "properties"),
                new ClassPathResource("config/local.app." + System.getenv("ENV") + "properties"),
                new ClassPathResource("config/application.properties")
        });
        properties.setBeanName("app");
        properties.setLocalOverride(true);
        properties.setIgnoreResourceNotFound(true);
        return properties;
    }


    public static Properties loadProperties(String propertiesPath) {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource(propertiesPath));
        Properties properties = null;
        try {
            propertiesFactoryBean.afterPropertiesSet();
            properties = propertiesFactoryBean.getObject();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

}