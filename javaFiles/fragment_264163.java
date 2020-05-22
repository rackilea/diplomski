@Configuration
public class PropertyFileLoaderConfig {

    private static final Logger LOG = LoggerFactory.getLogger(PropertyFileLoaderConfig.class);

    private static final String PROFILE_DEV = "dev";
    private static final String PROFILE_STAGE = "stage";
    private static final String PROFILE_PROD = "prod";

    private static final String PATH_TEMPLATE = "classpath*:%s/*.properties";

    @Bean
    @Profile(PROFILE_DEV)
    public static PropertySourcesPlaceholderConfigurer devPropertyPlaceholderConfigurer() throws IOException {
        LOG.info("Initializing {} properties.", PROFILE_DEV);
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setLocations(new PathMatchingResourcePatternResolver().getResources(getResourcesFromPath(PROFILE_DEV)));//Loads all properties files from the path
        configurer.setIgnoreUnresolvablePlaceholders(true);

        return configurer;
    }

    @Bean
    @Profile(PROFILE_STAGE)
    public static PropertySourcesPlaceholderConfigurer stagePropertyPlaceholderConfigurer() throws IOException {
        LOG.info("Initializing {} properties.", PROFILE_STAGE);
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setLocations(new PathMatchingResourcePatternResolver().getResources(getResourcesFromPath(PROFILE_STAGE)));

        return configurer;
    }

    @Bean
    @Profile(PROFILE_PROD )
    public static PropertySourcesPlaceholderConfigurer prodPropertyPlaceholderConfigurer() throws IOException {
        LOG.info("Initializing {} properties.", PROFILE_PROD );
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setLocations(new PathMatchingResourcePatternResolver().getResources(getResourcesFromPath(PROFILE_PROD )));

        return configurer;
    }

    private static String getResourcesFromPath(String path) {
        return PATH_TEMPLATE.replaceFirst("%s", path);
    }
}