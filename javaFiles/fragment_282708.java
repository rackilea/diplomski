FileAppender fa = new FileAppender(new PatternLayout("%d{[dd/MM/yyy HH:mm:ss]} :: %2p :: %C{1} : %M :: %m%n"),
          ".\LogFiles\scheduler.log");
  fa.setName("QuartzScheduler");
  fa.setThreshold(Level.ALL);
  fa.setAppend(true);
  fa.activateOptions();
  org.apache.log4j.Logger.getLogger("org.quartz").addAppender(fa);
  org.apache.log4j.Logger.getLogger("org.quartz").setLevel(Level.INFO);
  SimpleThreadPool threadPool = new SimpleThreadPool(25, Thread.NORM_PRIORITY);
  JobStore jobStore = new RAMJobStore();
  threadPool.setInstanceName("MyQuartz");
  DirectSchedulerFactory.getInstance().createScheduler(threadPool, jobStore);
  Scheduler operationScheduler = DirectSchedulerFactory.getInstance().getScheduler();
  operationScheduler.start();