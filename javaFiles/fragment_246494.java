@Configuration
@EnableScheduling

public class Configuration implements SchedulingConfigurer {
   @Bean(destroyMethod = "shutdown")
   public Executor taskExecutor() {
      return Executors.newScheduledThreadPool(100);
   }

    @Override
            public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
            CronTrigger cronTrigger
            = new CronTrigger("* * * * * *");

                    taskRegistrar.setScheduler(taskExecutor());
                    taskRegistrar.addTriggerTask(
                            new Runnable() {
                                @Override public void run() {
                                    System.out.println("RUN!!!");
                                }
                            },
                            cronTrigger
                    );
                }