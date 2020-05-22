@Configuration
public class AppConfig {

    private static String brand;

    @Value("${brand}")
    public void setBrand(String brand) {
        AppConfig.brand = brand;
    }

    @Bean
    public static String brandString() {
        return brand;
    }
...
}