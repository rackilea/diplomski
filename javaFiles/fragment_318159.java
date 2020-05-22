@EnableCaching
@Configuration
public class myConfiguration {
        @Bean(name = "CacheManager")
        public CacheManager cacheManager() {
            return new GuavaCacheManager("MyCache");
        }

        @Bean
        public MyClass myClass(){
            return new MyClass();
        }
}