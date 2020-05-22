public class ReadEvents {

public interface Event {
    @XBRead("./key")
    String getKey();

    @XBRead("./date using yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    Date getDate();

    @XBRead("../document/docuri")
    String getDocumentURI();

    @XBRead("../preceding-sibling::*[1]/event")
    Event getPreviousEvent();

    @XBRead("../following-sibling::*[1]/event")
    Event getNextEvent();
}

public static void main(String... args) {
    List<Event> allEvents = new XBProjector().io().url("res://log.xml").evalXPath("//event").asListOf(Event.class);
    for (Event event : allEvents) {
        System.out.print(event.getDate()+ ": Event " + event.getKey());
        if (event.getPreviousEvent() != null) {
            System.out.print(" previous event has key " + event.getPreviousEvent().getKey());
        }
        if (event.getNextEvent() != null) {
            System.out.print(" next event has key " + event.getNextEvent().getKey());
        }
        System.out.println();
    }
  }
}