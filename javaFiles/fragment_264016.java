ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
ZonedDateTime nextRun = now.withHour(5).withMinute(0).withSecond(0);
if(now.compareTo(nextRun) > 0)
    nextRun = nextRun.plusDays(1);

Duration duration = Duration.between(now, nextRun);
long initalDelay = duration.getSeconds();

ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);            
scheduler.scheduleAtFixedRate(new MyRunnableTask(),
    initalDelay,
    TimeUnit.DAYS.toSeconds(1),
    TimeUnit.SECONDS);