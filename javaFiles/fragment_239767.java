@Component
public class CustomSpringEventListener implements ApplicationListener<CustomSpringEvent> {
    private ServiceA serviceA;

    public CustomSpringEventListener(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

}