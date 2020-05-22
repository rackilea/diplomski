@Configuration
public class FlywayConfiguration {
    @Bean
    public FlywayConfigurationCustomizer customizeLicense(
                 @Value("${my-app.flyway.license}") String license) {
        return configuration -> configuration.licenseKey(license);
    }
}