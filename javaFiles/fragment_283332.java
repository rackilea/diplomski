@Autowired
public void config(final ConfigurableEnvironment confenv) {
    final YamlPropertiesFactoryBean yamlProperties = new YamlPropertiesFactoryBean();
    yamlProperties.setResources(new ClassPathResource("datasource.yml"));

    confenv.getPropertySources().addFirst(new PropertiesPropertySource("datasource", yamlProperties.getObject()));
}