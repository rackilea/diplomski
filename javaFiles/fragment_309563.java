@SpringBootApplication
public class CustomerApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder()
            .sources(CoreApplication.class, CustomerApplication.class)
            .run(args);
    }
}