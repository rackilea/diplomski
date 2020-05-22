public static boolean isJobRunning(JobExecutionContext ctx, String jobName, String groupName)
        throws SchedulerException {
    List<JobExecutionContext> currentJobs = ctx.getScheduler().getCurrentlyExecutingJobs();

    for (JobExecutionContext jobCtx : currentJobs) {
        String thisJobName = jobCtx.getJobDetail().getKey().getName();
        String thisGroupName = jobCtx.getJobDetail().getKey().getGroup();
        if (jobName.equalsIgnoreCase(thisJobName) && groupName.equalsIgnoreCase(thisGroupName)
                && !jobCtx.getFireTime().equals(ctx.getFireTime())) {
            return true;
        }
    }
    return false;
}