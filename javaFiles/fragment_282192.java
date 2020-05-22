public class StartEventListener implements
        ApplicationListener<ContextRefreshedEvent> {

    Logger          logger          = Logger.getLogger(StartEventListener.class);

    // Module launched by the applications using this Listener
    final Module    module;

    public StartEventListener(Module module) {
        super();
        this.module = module;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent applicationEvent) {
        logger.warn("Module " + module.getName() + " started");
    }
}