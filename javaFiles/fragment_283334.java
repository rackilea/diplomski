@Autowired
public void config (final ConfigurableEnvironment confenv) {
    final YamlPropertySourceLoader yamlPropertySourceLoader = new YamlPropertySourceLoader();
    try {
        final PropertySource<?> datasource =
                yamlPropertySourceLoader.load("datasource",
                                            new ClassPathResource("datasource.yml"),
                                            confenv.getActiveProfiles()[0]);
        confenv.getPropertySources().addFirst(datasource);
    } catch (final IOException e) {
        throw new RuntimeException("Failed to load datasource properties", e);
    }
}