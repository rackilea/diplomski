@Configuration
public class MyConfiguration {
    @Bean
    public InitializeFramework initializeFramework() {
        return new InitializeFramework();
    }
}