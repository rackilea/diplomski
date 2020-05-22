@Bean
public static PropertySourcesPlaceholderConfigurer properties() {
  PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
  YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
  yaml.setResources(new ClassPathResource("default.yml"));
  propertySourcesPlaceholderConfigurer.setProperties(yaml.getObject());
  return propertySourcesPlaceholderConfigurer;
}