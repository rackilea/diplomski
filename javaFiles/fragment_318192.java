public class SpringTest {
    @TestConfiguration
    public static class TestConfig {
        @Bean
        public MvcInterceptor interceptor() {
            return new MvcInterceptor();
        }
    }
}