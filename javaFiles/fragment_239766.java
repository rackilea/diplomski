@Component
public class CustomSpringEventListener implements ApplicationListener<CustomSpringEvent> {

    @Override
    @EventListener
    public void onApplicationEvent(CustomSpringEvent event) {
        System.out.println("Received spring custom event - " + event.getMessage());
    }

}