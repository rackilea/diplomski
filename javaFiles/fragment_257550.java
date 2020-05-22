QuartzScheduler quartzScheduler = ...

    Set<? extends Trigger> set = Sets.newHashSet(new SimpleTriggerImpl(), new CronTriggerImpl());

    Map<JobDetail, Set<? extends Trigger>> triggersAndJobs = Maps.newHashMap();
    triggersAndJobs.put(new JobDetailImpl(), set);

    quartzScheduler.scheduleJobs(triggersAndJobs, false);