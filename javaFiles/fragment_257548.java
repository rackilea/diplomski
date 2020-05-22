QuartzScheduler quartzScheduler = ...

    Set<Trigger> triggers = new HashSet<>();
    triggers.add(new SimpleTriggerImpl());
    triggers.add(new CronTriggerImpl());

    Map<JobDetail, Set<? extends Trigger>> triggersAndJobs = new HashMap<>();
    triggersAndJobs.put(new JobDetailImpl(), triggers);

    quartzScheduler.scheduleJobs(triggersAndJobs, false);