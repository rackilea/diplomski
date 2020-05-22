public class HelloJob implements Job {

    public HelloJob() {
    }

    public void execute(JobExecutionContext context) throws JobExecutionException
    {
        //do your job...

        Trigger trigger = newTrigger().build();
        JobDetail job = newJob(HelloJob.class).build();
        context.getScheduler().scheduleJob(trigger, job);
    }
}