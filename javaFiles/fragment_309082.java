/**
 * This example shows how to configure Spring's {@link CacheManager} with 
  Infinispan implementation.
 */
public class SpringAnnotationConfiguration {

    @Configuration
    public static class ApplicationConfiguration {

        @Bean
        public SpringEmbeddedCacheManagerFactoryBean springCache() {
            return new SpringEmbeddedCacheManagerFactoryBean();
        }

        @Bean
        public CachePlayground playground() {
            return new CachePlayground();
        }
    }

    public static class CachePlayground {

        @Autowired
        private CacheManager cacheManager;

        public void add(String key, String value) {
            cacheManager.getCache("default").put(key, value);
        }

        public String getContent(String key) {
            return cacheManager.getCache("default").get(key).get().toString();
        }
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        CachePlayground cachePlayground = applicationContext.getBean(CachePlayground.class);

        cachePlayground.add("Infinispan", "Is cool!");
        System.out.println(cachePlayground.getContent("Infinispan"));
    }
}