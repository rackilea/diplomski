QuartzScheduler quartzScheduler = ...

    Set<Trigger> triggers = new HashSet<Trigger>();

    Trigger trigger1 = newTrigger()
            .withIdentity(triggerKey("myTrigger", "myTriggerGroup"))
            .withSchedule(simpleSchedule()
                    .withIntervalInHours(1)
                    .repeatForever())
            .startAt(futureDate(10, DateBuilder.IntervalUnit.MINUTE))
            .build();
    triggers.add(trigger1);

    Trigger trigger2 = newTrigger() ...
    triggers.add(trigger2);

    Map<JobDetail, Set<? extends Trigger>> triggersAndJobs = new HashMap<JobDetail, Set<? extends Trigger>>();
    triggersAndJobs.put(new JobDetailImpl(), triggers);

    quartzScheduler.scheduleJobs(triggersAndJobs, false);