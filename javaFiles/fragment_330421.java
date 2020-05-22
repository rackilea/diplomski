@Component
public class StartupApplicationListener implements ApplicationListener<ApplicationReadyEvent> {

    @Inject
    private ConsumerRegistry registry;

    @Inject
    @Value("${consumerCount}")
    private int consumerCount;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        //do your logic
        for (int i = 0; i < consumerCount; i++) {
            // Each registered consumer results in a thread that consumes messages.
            // Incoming messages will be delivered to any consumer thread that's not busy.
            registry.registerConsumer(new Consumer());
        }
    }
}