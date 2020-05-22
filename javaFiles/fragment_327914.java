public abstract class EventListener implements InitializingBean {

Log log = LogFactory.getLog(this.getClass());

EventDispatcher eventDispatcher;

// Spring will call this method after auto-
// wiring is complete.
public void afterPropertiesSet() throws Exception {
    // let us register this instance with
    // event dispatcher
    eventDispatcher.registerListener(this);
}

/**
 * Implementation of this method checks whether the given event can be
 * handled in this class. This method will be called by the event
 * dispatcher.
 * 
 * @param event
 *            the event to handle
 * @return true if the implementing subclass can handle the event
 */
public abstract boolean canHandle(Object event);

/**
 * This method is executed by the event dispatcher with the event object.
 * 
 * @param event
 *            the event to handle
 */
public abstract void handle(Object event);

public void setEventDispatcher(EventDispatcher eventDispatcher) {
    this.eventDispatcher = eventDispatcher;
}
}