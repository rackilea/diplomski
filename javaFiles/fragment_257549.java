QuartzScheduler quartzScheduler = ...

    Set<Trigger> triggers = new HashSet<Trigger>();
    triggers.add(new SimpleTriggerImpl());
    triggers.add(new CronTriggerImpl());

    Map<JobDetail, Set<? extends Trigger>> triggersAndJobs = new HashMap<JobDetail, Set<? extends Trigger>>();
    triggersAndJobs.put(new JobDetailImpl(), triggers);

    quartzScheduler.scheduleJobs(triggersAndJobs, false);