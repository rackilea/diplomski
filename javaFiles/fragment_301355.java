public class TestContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        try {
            Resource resource = applicationContext.getResource("classpath:application.yml");
            YamlPropertySourceLoader sourceLoader = new YamlPropertySourceLoader();
            PropertySource<?> yamlTestProperties = sourceLoader.load("applicationProperties", resource, null);
            applicationContext.getEnvironment().getPropertySources().addFirst(yamlTestProperties);
            String[] profiles = applicationContext.getEnvironment().getProperty("spring.profiles.active").replaceAll(" ", "").split(",");
            applicationContext.getEnvironment().setActiveProfiles(profiles);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}