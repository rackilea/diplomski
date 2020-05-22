@SpringBootApplication
public class StackoverflowApplication {

    public static void main(String[] args) {
        SpringApplication.run(StackoverflowApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}