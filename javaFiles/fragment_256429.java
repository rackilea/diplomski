@Component
public class ApplicationListenerBean implements ApplicationListener<ApplicationReadyEvent> {

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        ConfigUtil.getVal("A");
    }
}