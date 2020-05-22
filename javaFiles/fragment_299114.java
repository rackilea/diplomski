@EnableCaching(mode = AdviceMode.ASPECTJ)
public class CacheConfig implements CachingConfigurer {

    public KeyGenerator keyGenerator() {
        return new ReflectionBasedKeyGenerator();
    }

    public CacheManager cacheManager() {
        return new RedisCacheManager(redisCacheTemplate);
    }
}