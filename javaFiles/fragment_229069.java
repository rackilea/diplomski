public class ActionEventHandler implements EventHandler<ActionEvent> {

    private final EventHandler<ActionEvent> eventHandler;
    private final String name;

    public ActionEventHandler(String name, EventHandler<ActionEvent> eventHandler) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(eventHandler);
        this.name = name;
        this.eventHandler = eventHandler;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void handle(ActionEvent event) {
        eventHandler.handle(event);
    }

}