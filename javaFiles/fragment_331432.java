_manager = new ServerConnectorManager(
                       getExecutor(),
                       getScheduler(),
                       selectors>0?
                       selectors:
                       Math.max(1,Math.min(4,Runtime.getRuntime().availableProcessors()/2)
                       ));
addBean(_manager, true);