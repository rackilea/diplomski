@Configuration
@EnableCaching
public class CachingConfig implements CachingConfigurer {
    @Bean
    @Override
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();

        List<Cache> caches = new ArrayList<Cache>();
        caches.add(new ConcurrentMapCache("myCacheName"));
        cacheManager.setCaches(caches);

        return cacheManager;
    }

    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        return new SimpleKeyGenerator();
    }

    @Bean
    @Override
    public CacheResolver cacheResolver()    {
        return new SimpleCacheResolver();
    }

    @Bean
    @Override
    public CacheErrorHandler errorHandler() {
         return new SimpleCacheErrorHandler();
    }
}