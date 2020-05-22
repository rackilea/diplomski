@Scheduled(cron = "0 * 11-22 * * *")
  public void processPerformances() {
    // do something();

  }

  @Scheduled(cron = "0 0 23 * * *")
  public void processPerformancesLastTime() {
    processPerformances();
  }