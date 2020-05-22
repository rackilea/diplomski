@Autowired
private SimpleApplicationEventMulticaster simpleApplicationEventMulticaster;

@Autowired
private AsyncTaskExecutor asyncTaskExecutor;

// ...

simpleApplicationEventMulticaster.setTaskExecutor(asyncTaskExecutor);

// ...

ApplicationEvent event = new ApplicationEvent("");
simpleApplicationEventMulticaster.multicastEvent(event);