@Configuration
public class SlackConfiguration {

    @Bean
    public Slack slack() {
        return Slack.getInstance();
    }
}