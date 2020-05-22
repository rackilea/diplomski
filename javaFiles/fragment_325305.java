//Add this to your gradle:
dependencies {
    implementation group: 'com.google.guava', name: 'guava', version: '24.1-jre'
}

//And this will become your code
public class GlobalCache {
    private static Cache<String, Object> cache = 
        CacheBuilder.newBuilder().maximumSize(100).expireAfterWrite(5, TimeUnit.MINUTES).build();

    public static Object getObject(String key, Callable<? extends Object> creator) throws ExecutionException {
        return cache.get(key, creator);
    }
}