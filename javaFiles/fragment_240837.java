@Configuration
@PropertySource("classpath:/properties/jdbc/jdbc.properties")
public class RootConfig {

    @Bean
    public static PropertySources PlaceholderConfigurer propertyPlaceholder() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}