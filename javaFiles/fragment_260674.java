@Configuration
public class Configuration {

    private EventHandlerRepository repository = new EventHandlerRepository();

    public Config() {
        // register all your event handlers here
        factory.registerHandler(EventType.A, new EventHandlerA());
    }

    @Bean
    public EventHandlerRepository getEventHandlerRepository() {
        return repository;
    }
}