@Configuration
 @EnableCaching
 class CachingConfig {

   @Bean
   CacheManager cacheManager() {

     SimpleCacheManager cacheManager = new SimpleCacheManager();
     cacheManager.addCaches(Arrays.asList(new ConcurrentMapCache("servicesByCustomerId)));

     return cacheManager;
   }
 }