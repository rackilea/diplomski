trigger = newTrigger()
    .withIdentity("mytrigger", "group1")
    .startNow()
    .withSchedule(simpleSchedule()
            .withIntervalInMinutes(5)
            .repeatForever())
    .build();