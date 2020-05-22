public class LightSwitchMain {

public static void main(String[] args) {

    Map<LocalDate, List<SwitchEvent>> eventContainer = new HashMap<>();

    // Example of a light switch OFF on Jan 1, 2016 at 9:45)
    LocalDate eventDate1 = LocalDate.of(2016, 1, 1);
    SwitchEvent event1 = new SwitchEvent(LocalTime.of(9, 45), 0);

    addSwitchEvent(eventContainer, eventDate1, event1);

    // Light goes on
    SwitchEvent event2 = new SwitchEvent(LocalTime.of(9, 55), 1);
    addSwitchEvent(eventContainer, eventDate1, event2);

}

static void addSwitchEvent(Map<LocalDate, List<SwitchEvent>> eventContainer, LocalDate eventDate, SwitchEvent event) {
    List<SwitchEvent> dayEvents = eventContainer.get(eventDate);
    if (dayEvents == null) {
        dayEvents = new ArrayList<SwitchEvent>();
        eventContainer.put(eventDate, dayEvents);
    }
    dayEvents.add(event);
}

static class SwitchEvent {
    final LocalTime eventTime;  // Time of the light switch
    final int switchState;      // 0=off, 1=on
    public SwitchEvent(LocalTime eventTime, int switchState) {
        this.eventTime = eventTime;
        this.switchState = switchState;
    }
}

}