public enum MyCache {
    INSTANCE;

    private static Cache<Integer, LoadingCache<String, List<Integer>>> cache =
            CacheBuilder.newBuilder()
                    .maximumSize(1000)
                    .build();

    private static AtomicInteger uniqueCount = new AtomicInteger(0);

    public int newMapItem() {
        int key = uniqueCount.incrementAndGet();

        //We dont care if something exists
        cache.put(key, CacheBuilder.newBuilder().build(ListCacheLoader.INSTANCE));

        return key;
    }

    public void expireMapItem(int key) {
        cache.invalidate(key);
    }

    public boolean add(int cacheKey, String mapListKey, int value) {
        // You don't need to synchronize here, since the creation of the map is not
        // synchronized. So either it has been created before, or it hasn't, but there
        // won't be a concurrency problem since Cache is thread-safe.
        LoadingCache<String, List<Integer>> cachedMap = cache.getIfPresent(cacheKey);
        if (cachedMap == null) {
            // We DON'T want to create a new map automatically if it doesn't exist
            return false;
        }

        List<Integer> mappedList = cachedMap.getUnchecked(mapListKey);

        // ArrayList is not synchronized, so that's the only part you actually need to
        // guard against concurrent modification.
        synchronized (mappedList) {
            mappedList.add(value);
        }

        return true;
    }

    private static class ListCacheLoader extends CacheLoader<String, List<Integer>> {
        public static final ListCacheLoader INSTANCE = new ListCacheLoader();

        @Override
        public List<Integer> load(String key) {
            return Lists.newArrayList();
        }
    }
}