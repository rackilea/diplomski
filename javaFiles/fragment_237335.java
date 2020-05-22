@Configuration
@ComponentScan
@Profile("test")
@PropertySource(value = "classpath:/yourApp.properties")
public class TestConfiguration {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}