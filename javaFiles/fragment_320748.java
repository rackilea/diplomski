@Configuration
public class PropertiesConfiguration {

  @Bean
  public static DecryptingPropertiesFactoryBean propertyFactory() {
    final DecryptingPropertiesFactoryBean factory = new DecryptingPropertiesFactoryBean();
    final Resource[] propertyLocations = new Resource[] {
        new FileSystemResource(new File("path/to/file.properties"))
    };
    factory.setLocations(propertyLocations);
    return factory;
  }

  @Bean
  public static Properties properties() throws Exception {
    return propertyFactory().getObject();
  }

  @Bean
  public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
    final PropertySourcesPlaceholderConfigurer bean = new PropertySourcesPlaceholderConfigurer();
    bean.setIgnoreResourceNotFound(true);
    bean.setIgnoreUnresolvablePlaceholders(false);
    bean.setProperties(properties());
    return bean;
  }
}