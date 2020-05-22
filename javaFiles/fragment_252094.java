public class CronTriggerRunner {

public static void main(String args[]) throws SchedulerException, Exception {

    SchedulerFactory schedulerFactory = new StdSchedulerFactory();

    Scheduler scheduler = schedulerFactory.getScheduler();

    JobDetail job = JobBuilder.newJob(ClassToRun.class).withIdentity("jobName", "group").build();
    // Starting CronTrigger
    String exp = "0 0 9 * * ?"; //trigger format, everyday at 9:00 am

    Trigger trigger = TriggerBuilder.newTrigger()
                                .startNow()
                                .withSchedule(
                                     CronScheduleBuilder.cronSchedule(exp))
                                .build();

    // Planning job detail
    scheduler.scheduleJob(job, trigger);

    // starting scheduler
    scheduler.start();
}
}