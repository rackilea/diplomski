@Configuration
public class FlywayConfiguration {
    @Bean
    public FlywayConfigurationCustomizer customizeLicense(
                 @Value("${my-app.flyway.license}") String license) {
        return new FlywayConfigurationCustomizer() {

            @Override
            public void customize(FluentConfiguration configuration) {
                configuration.licenseKey(license);
            }
        };
    }
}