@Bean
public CacheManager cacheManager() {
    final CacheManager cacheManager;        
    if (this.methodCacheManager != null) {
        final EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager();
        ehCacheCacheManager.setCacheManager(this.methodCacheManager);
        cacheManager = ehCacheCacheManager;
    } else {
        cacheManager = new NoOpCacheManager();
    }

    return cacheManager;
}