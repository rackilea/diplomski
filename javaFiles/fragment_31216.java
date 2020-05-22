public class EventPublisher {

    private final Event ValueUpdatedEvent = new Event();

    public void addEventHandler(Event.EventHandler eventHandler){
        ValueUpdatedEvent.add(eventHandler);
    }

    public void removeEventHandler(Event.EventHandler eventHandler){
        ValueUpdatedEvent.remove(eventHandler);
    }

    public void UpdateValue(){
        ValueUpdatedEvent.invoke();
    }
}