@Configuration
@PropertySource("classpath:database.properties")
public class ContextConfigutarion {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer ();
    }
}