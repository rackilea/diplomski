@Configuration
public class ServiceConfig {

    @Bean
    public SentimentClient firstClient() {
        return new FirstClient();
    }

    @Bean
    public SentimentClient secondClient() {
        return new SecondClient();
    }
}