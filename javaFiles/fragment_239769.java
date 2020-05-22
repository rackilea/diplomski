@Configuration
public ListenerConfig {

    public CustomSpringEventListener listenerA() {
        return new CustomSpringEventListener("listenerA");
    }

    public CustomSpringEventListener listenerB() {
        return new CustomSpringEventListener("listenerB");
    }

    public CustomSpringEventListener listenerC() {
        return new CustomSpringEventListener("listenerC");
    }

    ...
}