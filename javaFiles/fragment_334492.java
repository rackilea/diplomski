/**
 * Schedules a DATA_MINING_JOB for the client. The job will attempt to enter
 * followers of the target into the database.
 */
@Override
public void schedule(JobContext context) {
    Client client = context.getNetworkSociallyJob().getClient();
    this.logScheduleAttempt(context, client);

    JobDetail jobDetails = JobBuilder.newJob(this.getJobClass()).withIdentity(context.getQuartzName(), context.getQuartzGroup()).build();
    jobDetails.getJobDataMap().put("job", context.getNetworkSociallyJob());
    jobDetails.getJobDataMap().put("repositories", context.getRepositories());

    Trigger trigger = TriggerBuilder.newTrigger().withIdentity(context.getQuartzName() + "-trigger", context.getQuartzGroup())
            .withSchedule(cronSchedule(this.getSchedule())).build();

    try {
        context.getScheduler().scheduleJob(jobDetails, trigger);            
        this.logSuccess(context, client);

    } catch (SchedulerException e) {
        this.logFailure(context, client);
        e.printStackTrace();
    }
}