@Configuration
@EnableScheduling
public class SchedulerConfig implements SchedulingConfigurer {

    /* ............ */

    @Bean(name = "executorService")
    ExecutorService taskExecutors() {
        return Executors.newScheduledThreadPool(10);
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutors());
    }

}