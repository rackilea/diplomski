@Override
public void jobStart() {
    this.loadJob(SchedHourlyJob.class, "hourlyjob", "grouphourly", START_INTERVAL, EXECUTION_INTERVAL);
}

@Override
public void jobStop() {
    logger.info("-- jobStop. Stopping Scheduled Job");

    try {
        scheduler.deleteJob(new JobKey("hourlyjob", "grouphourly"));
    } catch (SchedulerException schedEx) {
        logger.error("Failed to stop scheduled job. Exception message and stacktrace  ==> " ,schedEx);
    }
}