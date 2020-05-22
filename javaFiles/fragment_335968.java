@AllArgsConstructor
class Test {
  private CacheManager cacheManager;

  Set<Object> keys(String cacheName){
    CaffeineCache caffeineCache = (CaffeineCache) cacheManager.getCache(cacheName);
    com.github.benmanes.caffeine.cache.Cache<Object, Object> nativeCache = caffeineCache.getNativeCache();
    return nativeCache.asMap().keySet();
  }

}