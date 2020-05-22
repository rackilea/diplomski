Trigger[] triggers = // ... (getTriggersOfJob)
for (Trigger trigger : triggers) {
    if (trigger instanceof CronTrigger) {
        CronTrigger cronTrigger = (CronTrigger) trigger;
        String cronExpr = cronTrigger.getCronExpression();
    }
}