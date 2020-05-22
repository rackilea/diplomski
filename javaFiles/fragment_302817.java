final class EventType<E> {
    private EventType(){}
    public final static EventType<BaseEvent> SimpleEvent = new EventType<BaseEvent>();
    public final static EventType<BaseEvent> SimpleEvent2 = new EventType<BaseEvent>();
    public final static EventType<ComplexEvent> ComplexEvent1 = new EventType<ComplexEvent>();
    public final static EventType<ComplexEvent> ComplexEvent2 = new EventType<ComplexEvent>();
}