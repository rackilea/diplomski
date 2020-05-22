public class CustomSpringEventListener implements ApplicationListener<CustomSpringEvent> {
    private String name;

    public CustomSpringEventListener(String name) {
        this.name = name;
    }

    @Override
    @EventListener
    public void onApplicationEvent(CustomSpringEvent event) {
        System.out.println(name + " received spring custom event - " + event.getMessage());
    }

}