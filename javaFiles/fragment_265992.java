@Configuration
public class AppConfig{
    ...

    @Bean
    public DataInitializer createDataInitializer(){
        return new DataInitializer();
    }
}