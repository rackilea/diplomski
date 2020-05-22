final LocalDateTime now = LocalDateTime.now();
final LocalDateTime ninePMToday = LocalDateTime.now()
                                               .withHour(21)
                                               .withMinute(0)
                                               .withSecond(0)
                                               .withNano(0);
final ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
ses.schedule(() -> System.out.println("It's 9pm!"),
             now.until(ninePMToday, ChronoUnit.MILLIS),
             TimeUnit.MILLISECONDS);