@Bean
public PropertySourcesPlaceholderConfigurer config(final ConfigurableEnvironment confenv) {
    final PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
    final YamlPropertiesFactoryBean yamlProperties = new YamlPropertiesFactoryBean();
    yamlProperties.setResources(new ClassPathResource("datasource.yml"));
    configurer.setProperties(yamlProperties.getObject());

    confenv.getPropertySources().addFirst(new PropertiesPropertySource("datasource", yamlProperties.getObject()));

    return configurer;
}