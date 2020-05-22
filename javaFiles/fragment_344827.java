Map<Class, Set<MessageListener>> registrations = new HashMap<Class, Set<MessageListener>>();

public void register(Class clazz, MessageListener listener) {
    Set<MessageListener> listeners = registrations.get(clazz);
    if (listeners == null) {
        listeners = new HashSet<MessageListener>();
        registrations.put(clazz, listeners);
     }
     listeners.add(listener);
 }