ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

scheduler.scheduleWithFixedDelay(
        () -> queryMongoAndDoSomeLogic(),
        0,
        30,
        TimeUnit.SECONDS);