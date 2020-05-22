import org.reactfx.EventSource;
import org.reactfx.EventStream;
import org.reactfx.Subscription;

class BlahModel {

    private EventSource<Integer> events = new EventSource<>();

    public EventStream<Integer> events() { return events; }

    void foo() {
        // fire event
        events.push(42);
    }
}

class BlahController {
    private final Subscription eventSubscription;

    BlahController(BlahModel blahModel) {
        eventSubscription = blahModel.events().subscribe(
                i -> System.out.println("Received event " + i));
    }

    public void dispose() {
        eventSubscription.unsubscribe();
    }
}