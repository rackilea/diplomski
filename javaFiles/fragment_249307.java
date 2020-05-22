@Configuration
public class ApplicationConfig {

    @Bean
    public Filter securityFilter() {
        return new SecurityFilter();
    }

}