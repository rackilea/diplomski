public class GlobalCache {

    private static ConcurrentHashMap<String, Object> cacheMap = new ConcurrentHashMap<>();

    public static Object getObject(String key, Function<String, Object> creator) {
        return cacheMap.computeIfAbsent(key, creator);
    }

}