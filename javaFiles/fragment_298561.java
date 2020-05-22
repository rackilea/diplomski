@EventListener(ApplicationReadyEvent.class)
    public void doAfterStartup() {
        Hystrix.reset();
        registerCustomHystrixEventNotifier(circuitBreakerHystrixEventNotifier);
        logger.info("hello world, application started up");
    }