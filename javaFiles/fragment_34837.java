public interface EventListener<E,S> {
    void processEvent(E event, S source);
}
public abstract class ComponentEvent extends CancelableEvent implements SidedEvent {
    // not dealing with source anymore…
}