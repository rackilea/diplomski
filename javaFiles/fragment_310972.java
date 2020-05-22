@Configuration
public class DataConfiguration {
    @Bean
    public MyDao myDao() {
        return new MyDao();
    }
}