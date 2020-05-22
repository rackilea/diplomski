private Class<? extends EventListener> getListenerType(EventListener listener){
    for(Class<? extends EventListener> listenerType : SUPPORTED_LISTENER_TYPES){
        if(listenerType.isAssignableFrom(listener.getClass())){
            return listenerType;
        }
    }
    return null;
}