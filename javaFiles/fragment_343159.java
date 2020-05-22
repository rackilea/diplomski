@Bean
public CacheManager cacheManager() {

   final CaffeineCacheManager manager = new CaffeineCacheManager();
   final Caffeine<Object, Object> caffeineBuilder = Caffeine.newBuilder()
                         .expireAfterWrite(30, TimeUnit.DAYS);
   manager.setCaffeine(caffeineBuilder);
   return manager;

}