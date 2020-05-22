for (BasePlan plan : DummyData.getWaitingPlans()) {

            System.out.println(plan.getName() + " created...");
            JobBuilder jobBuilder = JobBuilder.newJob(BackupJobFactory.class);
            JobDetail job = jobBuilder.withIdentity(plan.getName(), plan.getName()).build();
            job.getJobDataMap().put("basePlan", plan);

            Trigger trigger = TriggerBuilder
                    .newTrigger()
                    .withSchedule(CronScheduleBuilder.cronSchedule(plan.getSchedule()))
                    .build();

            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.start();
            scheduler.scheduleJob(job, trigger);
        }
    }