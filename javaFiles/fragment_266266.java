@Configuration
 @EnableScheduling
 public class AppConfig implements SchedulingConfigurer {

     @Override
     public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
         taskRegistrar.setScheduler(taskScheduler());
     }

     @Bean(destroyMethod="shutdown")
     public Executor taskScheduler() {
         return Executors.newScheduledThreadPool(42);
     }

 }