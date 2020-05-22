@SpringBootApplication
public class StackoverflowWebmvcSandboxApplication {
    @Bean
    public HealthIndicator dbHealthIndicator() {
        return new HealthIndicator() {

            @Override
            public Health health() {
                return Health.status(Status.UP).withDetail("hello", "hi").build();
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(StackoverflowWebmvcSandboxApplication.class, args);
    }

    @RestController
    public class HelloController {
        @GetMapping("/hello")
        public String hello() {
            return "hello";
        }
    }
}