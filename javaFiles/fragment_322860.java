@Component
public class SlackService {
    private final Slack slack;

    @Autowired
    public SlackService(final Slack slack) {
        this.slack = slack;
    }

    public String sendMessage(final Object message) {
        final WebhookResponse res = slack.send(url, payload);
        // etc
    }
}