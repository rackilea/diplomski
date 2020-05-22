@Component
public class MyEnvironmentPostProcessor implements
        EnvironmentPostProcessor, ApplicationListener<ApplicationEvent> {

    private static final DeferredLog log = new DeferredLog();

    @Override
    public void postProcessEnvironment(
            ConfigurableEnvironment env, SpringApplication app) {
        log.error("This should be printed");
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        log.replayTo(MyEnvironmentPostProcessor.class);
    }
}