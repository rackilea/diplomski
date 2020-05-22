trigger2 = TriggerBuilder
                    .newTrigger()
                    .withIdentity("abc", "group1")
                    .withSchedule(
                      CronScheduleBuilder.cronSchedule("0/30 * 14-23 * * ?"))
                    .build();