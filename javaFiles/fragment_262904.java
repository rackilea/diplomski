class MapPrinter {

    private static Map<String, String> createNewMap() {
        return Collections.synchronizedMap(new HashMap<String, String>());
    }

    private Map<String, String> map = createNewMap();

    void add(String key, String value) {
        // put is atomic due to synchronizedMap
        map.put(key, value);
    }

    void printKeys() {
        // to iterate, we need to synchronize on the map
        synchronized (map) {
            for (String key : map.values()) {
                System.out.println("Key:" + key);
            }
        }
    }

    void clear() {
        // hmmm.. this does not look right
        synchronized(map) {
            map = createNewMap();
        }
    }
}