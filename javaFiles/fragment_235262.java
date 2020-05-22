public class EventFactory {
    public static Event createSpecificEvent(String eventName, long delayTime) {
        Event event;

        switch (eventName) {  // String switch-case statements since Java 7
        case "ThermostatNight":
            event = new ThermostatNight(delayTime);
            break;
        case "AnotherEventClass":
            event = new AnotherEventClass(delayTime);
            break;
        default:
            throw new IllegalArgumentException("Unknown event type.");
        }

        return event;
    }
}