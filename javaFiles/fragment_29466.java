public Integer add(int cacheKey, String mapListKey, int value) {
    // You don't need to synchronize here, since the creation of the map is not
    // synchronized. So either it has been created before, or it hasn't, but there
    // won't be a concurrency problem since Cache is thread-safe.
    ConcurrentMap<String, List<Integer>> cachedMap = cache.getIfPresent(cacheKey);
    if (cachedMap == null){
        // We DON'T want to create a new map automatically if it doesn't exist
        return null;
    }

    // CHM is of course concurrent, so you don't need a synchronized block here
    // either.
    List<Integer> mappedList = cachedMap.get(mapListKey);
    if (mappedList == null) {
        List<Integer> newMappedList = Lists.newArrayList();
        mappedList = cachedMap.putIfAbsent(mapListKey, newMappedList);
        if (mappedList == null) {
            mappedList = newMappedList;
        }
    }

    // ArrayList is not synchronized, so that's the only part you actually need to
    // guard against concurrent modification.
    synchronized (mappedList) {
        mappedList.add(value);
    }

    return value;
}