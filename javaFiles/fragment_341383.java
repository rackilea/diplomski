import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.EventInterceptor;

public class LogEventInterceptor implements EventInterceptor {

public Event beforeProcessEvent(Event event) {
    System.out.println(event.getName() + " event received for + "
            + event.getTarget().getId() + "!!!");
    return event;
}
// rest of the impl