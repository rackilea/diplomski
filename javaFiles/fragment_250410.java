class MyShutdownHook extends Thread {
    private AbstractApplicationContext ctx;
    public MyShutdownHook(AbstractApplicationContext ctx) {
        this.ctx = ctx;
    }
    public void run() {
        ctx.close();
        Set<LoggerContext> contexts = new HashSet<>();
        for (Logger logger : LoggerContext.getLoggers()) {
            contexts.add(logger.getContext());
        }
        for (LoggerContext ctx : contexts) {
            Configurator.shutdown(LogManager.getContext());
        }
    }
}

AbstractApplicationContext ctx = /* create context */
Runtime.getRunTime().addShutdownHook(new MyShutdownHook(ctx);