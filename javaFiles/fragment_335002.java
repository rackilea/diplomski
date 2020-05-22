public class SchedulingConfiguration implements SchedulingConfigurer {
   @Bean
   public TaskScheduler taskScheduler() {
    ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
    scheduler.setThreadNamePrefix("TaskScheduler");
    scheduler.setPoolSize(10);      
    scheduler.setWaitForTasksToCompleteOnShutdown(true);
    scheduler.setAwaitTerminationSeconds(20);
    return scheduler;
}
@Override
public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
    taskRegistrar.setScheduler(taskScheduler());
    taskRegistrar.addTriggerTask(new Runnable() {
        @Override
        public void run() {
                // Code which which should run at the specified executionTime( specified in nextExecutionTime(TriggerContext triggerContext))
        }
    }, new Trigger() {
        @Override
        public Date nextExecutionTime(TriggerContext triggerContext) {
            Calendar nextExecutionTime = new GregorianCalendar();
            Date lastActualExecutionTime = triggerContext.lastActualExecutionTime();
            nextExecutionTime.setTime(lastActualExecutionTime != null ? lastActualExecutionTime : new Date());
            nextExecutionTime.add(Calendar.MINUTE, 2); // runs every 2 minute and can also be read from database instead of hardcoding
            return nextExecutionTime.getTime();
        }
    });
}