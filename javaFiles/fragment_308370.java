JobDetail jobDetail = JobBuilder.newJob(YourJob.class)
        .withIdentity("your-job-name", "your-job-group")
        .build();
Trigger trigger = TriggerBuilder.newTrigger()
        .withIdentity("your-trigger-name", "your-trigger-group")
        .withSchedule(CronScheduleBuilder.cronSchedule("0 0 * * ? *"))
        .startNow()
        .build();
scheduler.scheduleJob(jobDetail, trigger);
scheduler.start();