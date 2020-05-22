// AbstractEvent.java
public abstract class AbstractEvent<T extends AbstractEvent.EventListener> {
    public interface EventListener { }

    protected static Map<Class<? extends AbstractEvent>, Set<EventListener>> listeners = new HashMap<>();

    public final boolean addListener(T listener) {
        Set<EventListener> eventListeners = listeners.getOrDefault(getClass(), new HashSet<>());
        if (!listeners.containsKey(getClass())) {
            listeners.put(getClass(), eventListeners);
        }
        return eventListeners.add(listener);
    }

    public final boolean removeListener(T listener) {
        Set<EventListener> eventListeners = listeners.get(getClass());
        if (eventListeners != null) {
            return eventListeners.remove(listener);
        }
        return false;
    }
}

// SomeEvent.java
public class SomeEvent extends AbstractEvent<SomeEvent.SomeEventListener> {
    public interface SomeEventListener extends AbstractEvent.EventListener {
        void someMethod();
    }
}