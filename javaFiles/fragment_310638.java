public final class FLEXSyncFactory implements ApplicationContextAware {

    private static AbstractApplicationContext context;

    public void setApplicationContext(ApplicationContext applicationContext)
    throws BeansException {
        context = (AbstractApplicationContext) applicationContext;
    }