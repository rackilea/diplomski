@SpringBootApplication
public class YourApplicationMainClass {

    public static void main(String[] args) {
        ApiContextInitializer.init();

        SpringApplication.run(YourApplicationMainClass.class, args);
    }
}