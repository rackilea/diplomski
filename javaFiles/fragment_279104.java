@Configuration
@ConditionalOnMissingBean(annotation = ControllerAdvice.class)
public class FrameworkAdviceConfig {
    @Bean
    public FrameworkAdvice frameworkAdvice() {
        return new FrameworkAdvice() {
        };
    }
}