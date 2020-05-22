public class VersionEventListenerAdapter extends ServiceEventListenerAdapter {

public VersionEventListenerAdapter(String serviceId) {
    super(serviceId);
}

public void notifyVetoableEvent(Object event) throws WTException, WTPropertyVetoException {
    if (!(event instanceof KeyedEvent)) {
        return;
    }

    Object target = ((KeyedEvent) event).getEventTarget();
    Object eventType = ((KeyedEvent) event).getEventType();

    if (eventType.equals(VersionControlServiceEvent.NEW_VERSION)
    {
       /** Call your business code here 
           example : yourMethod(target);
        **/
    }
}