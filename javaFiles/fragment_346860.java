@Bean
public TaskScheduler taskScheduler() {
    TaskScheduler scheduler = new ThreadPoolTaskScheduler();

    scheduler.setPoolSize(2);
    scheduler.setThreadNamePrefix("scheduled-task-");
    scheduler.setDaemon(true);

    return scheduler;
}