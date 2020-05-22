private final Object lockObject = new Object();
private volatile Map<...> map;

void monitorThread{
    while (condition){
        // do this outside of the synchronized in case it takes a while
        Map<...> updatedMap = updatedMap();
        synchronized (lockObject) {
           map = updatedMap;
           // notify everyone that may be waiting for the map to be initialized
           lockObject.notifyAll();
        }
    }
}

String readValueFromMap(String key) {
    // we grab a copy of the map to avoid race conditions in case the map is
    // updated in the future
    Map<...> mapRef = map;
    // we have a while loop here to handle spurious signals
    if (mapRef == null) {
        synchronized (lockObject) {
           while (map == null) {
               // wait for the map to initialized
               lockObject.wait();
           }
           mapRef = map;
        }
    }
    return mapRef.get(key);
}