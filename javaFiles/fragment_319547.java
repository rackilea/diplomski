@Autowired
private Scheduler scheduler;
@Autowired
private IntervalCalculationStrategy intervalCalculation;

public <T extends QuartzJobBean> void registerSecurePayPostServiceJob(
    JobExecutionContext firedJobExecutionContext) {
  Optional<SimpleTriggerImpl> mutableTrigger =
      ofNullable(firedJobExecutionContext)
          .map(JobExecutionContext::getTrigger)
          .filter(SimpleTriggerImpl.class::isInstance)
          .map(SimpleTriggerImpl.class::cast);
  try {
    if (mutableTrigger.isPresent()) {
      SimpleTriggerImpl trigger = mutableTrigger.get();
      int nextAttemptNumber = trigger.getTimesTriggered();
      log.trace("trigger: {} fired [{}] times", trigger.getFullName(),
          trigger.getTimesTriggered());
      trigger.setStartTime(intervalCalculation.calculateNextTryDate(nextAttemptNumber));
      this.scheduler.rescheduleJob(trigger.getKey(), trigger);
    }
  } catch (SchedulerException e) {
    log.error("job was not rescheduled <{}>", firedJobExecutionContext.getJobDetail(), e);
  }
}