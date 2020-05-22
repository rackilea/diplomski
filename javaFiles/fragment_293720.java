import org.springframework.core.env.Environment;

public class Example {

    private boolean skipNextEvent;

    @Autowired
    public Example(Environment environment) {
        skipNextEvent = environment.acceptsProfiles("test");
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (skipNextEvent) {
            skipNextEvent = false;
            return;
        }
        startWebSocketConnection();
    }

    // ...
}