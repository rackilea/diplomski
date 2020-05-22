public class FocusEvent extends Event {

    public static final EventType FOCUS_EVENT_TYPE = new EventType(EventType.ROOT);

    public FocusEvent(Object source, EventTarget target) {
        super(source, target, FOCUS_EVENT_TYPE);
    }

}