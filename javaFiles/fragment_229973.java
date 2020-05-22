import com.google.common.eventbus.EventBus;

public class EventBusHolder {

    private static EventBus bus = new EventBus();

    public static EventBus get() {
        return bus;
    }
}