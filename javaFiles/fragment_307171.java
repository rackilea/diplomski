ServletContext ctx = request.getServletContext();
StdSchedulerFactory factory = (StdSchedulerFactory) ctx.getAttribute(QuartzListener.QUARTZ_FACTORY_KEY);
Scheduler scheduler = factory.getScheduler();
Trigger trigger = TriggerBuilder.newTrigger().withIdentity("simple").withSchedule(
        CronScheduleBuilder.cronSchedule(newCronExpression)).startNow().build();
Date date = scheduler.rescheduleJob(new TriggerKey("simple"), trigger);