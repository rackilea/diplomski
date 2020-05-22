@Configuration
@EnableScheduling
public class MySpringConfig {

 @Bean
 public TaskScheduler taskScheduler() {
     //org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler
     return new ThreadPoolTaskScheduler();
 }
}