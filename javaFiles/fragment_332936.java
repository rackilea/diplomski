@Configuration
public class ValidationConfig {
    @Bean public LocalValidatorFactoryBean defaultValidator() {
        return new LocalValidatorFactoryBean();
    }

    @Bean public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }
}