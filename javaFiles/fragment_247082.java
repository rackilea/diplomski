@Configuration
@PropertySource("file:config.properties")
public class ApplicationConfiguration {

    @Value("${gMapReportUrl}")
    private String gMapReportUrl;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}