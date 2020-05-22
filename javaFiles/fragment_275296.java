private static final ConcurrentHashMap<Object, Object> LOCKS = new ConcurrentHashMap<Object, Object>();
public static void saveSomethingImportantToDataBase(Object theObjectIwantToSave) {
    synchronized (LOCKS.putIfAbsent(theObjectIwantToSave.getId(), new Object())) {
        ....    
    }
    LOCKS.remove(theObjectIwantToSave.getId()); // Clean up lock object to stop memory leak
}