/* ... */
Trigger trigger2 = TriggerBuilder
    .newTrigger()
    .forJob(job.getKey())
    .withIdentity("trigger2", "group1")
    .startNow()
    .withSchedule(sb2)
    .build();
/* ... */
scheduler.scheduleJob(trigger2);
/* ... */