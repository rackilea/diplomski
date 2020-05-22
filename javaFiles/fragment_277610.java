JobDetail jobDetail = JobBuilder.newJob(StoredProcedureJob.class)
                    .withIdentity("dataJob", "dataJobGroup")
                    .storeDurably(true)
                    .requestRecovery(true)
                    .build();

            SimpleTrigger trigger = (SimpleTrigger) newTrigger()
                    .withIdentity("trigger1", "dataJobGroup")
                     .startNow()
                    .withSchedule(
                            simpleSchedule().withIntervalInSeconds(1)
                                    .repeatForever()).build();

            scheduler.scheduleJob(jobDetail, trigger);