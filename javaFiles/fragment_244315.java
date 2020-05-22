private Scheduler scheduler;

  @PostConstruct
  public void postInit() {
    logger.logInfo("Starting all jobs");
    StdSchedulerFactory factory = new StdSchedulerFactory();
    try {
      factory.initialize(App.class.getClassLoader().getResourceAsStream("quartz.properties"));
      scheduler = factory.getScheduler();
      // starts all our jobs using quartz_config.xml file
      scheduler.start();
    } catch (SchedulerException ex) {
      logger.logError("error while starting scheduler= ", ExceptionUtils.getStackTrace(ex));
    }
  }

  @PreDestroy
  public void shutdown() throws SchedulerException {
    logger.logInfo("Shutting down all jobs");
    scheduler.shutdown();
  }