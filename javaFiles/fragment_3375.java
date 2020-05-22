public class CacheHashMap {

    private int iterationValue = 3;
    static Map<String, String> dbSimulator = new HashMap<String, String>();

    private Map<String, CacheItem> cacheMap = new HashMap<>();

    static{
        dbSimulator.put("Vijay","VJ");
        dbSimulator.put("Smith","SM");
        dbSimulator.put("Raj","RJ");
    }

    public CacheHashMap(int n) {
        this.iterationValue = n;
    }

    public String getValue(String key) {
        CacheItem item = cacheMap.get(key);
        if (item == null || item.isExpired()) {
            // Load from DB
            String value = dbSimulator.get(key);
            cacheMap.put(key, new CacheItem(iterationValue, value));
            return value;
        } else {
            return item.getValue();
        }
    }

    private class CacheItem {
        private int iteration;
        private String value;

        public CacheItem(int iteration, String value) {
            this.iteration = iteration;
            this.value = value;
        }

        public boolean isExpired() {
            iteration--;
            return iteration < 0;
        }

        public String getValue() {
            return value;
        }
    }
}