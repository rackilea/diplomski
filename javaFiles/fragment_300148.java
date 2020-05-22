@Override
  public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
    taskRegistrar.setScheduler(this.taskExecutor());
    taskRegistrar.addTriggerTask(
      () -> logger.info("The time is {}", dateFormat.format(new Date())),
      (tc) -> {
        Date lastCompletion = tc.lastCompletionTime();
        if (lastCompletion == null) {
          lastCompletion = new Date();
        }
        Calendar cal = new Calendar.Builder().setInstant(lastCompletion).build();
        int second = ThreadLocalRandom.current().nextInt(0, 60);
        long minute = 60000L + second * 1000L;
        Date nextRun = new Date(cal.getTime().getTime() + minute);
        logger.info("Next run will be at {}", nextRun);
        logger.info("Time between runs is {}", minute);
        return new Date();
      });
  }