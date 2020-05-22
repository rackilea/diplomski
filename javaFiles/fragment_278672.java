@SpringBootApplication
@ConfigurationProperties
@EnableScheduling
public class Main {
    @Bean
    ThreadPoolTaskScheduler taskScheduler() {
        return new ThreadPoolTaskScheduler();
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}