@SuppressWarnings("unchecked")
public void addListener(EventListener listener) {
    if(listener == null){
        return;
    }
    Class<? extends EventListener> listenerType = getListenerType(listener);
    if(listenerType == null){
        throw new IllegalArgumentException("Listener " + listener + " not supported");
    }
    listenerList.add((Class<EventListener>)getListenerType(listener), listener);
}