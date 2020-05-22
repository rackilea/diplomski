public class InMemoryClientFactory implements FactoryBean<InMemoryClientExecutor>{

    @Inject
    private SessionResource sessionResource;

    @Override
    public InMemoryClientExecutor getObject() throws Exception {
        Dispatcher dispatcher = MockDispatcherFactory.createDispatcher();
        Registry registry = dispatcher.getRegistry();
        registry.addSingletonResource(unwrapProxy(sessionResource));
        final InMemoryClientExecutor inMemoryClientExecutor = new InMemoryClientExecutor(dispatcher);
    }

    @Override
    public Class getObjectType() {
        return InMemoryClientExecutor.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    private static Object unwrapProxy(Object bean) throws Exception {
        Object result = bean;
        /*
         * If the given object is a proxy, set the return value as the object
         * being proxied, otherwise return the given object.
         */
        if (AopUtils.isAopProxy(bean) && bean instanceof Advised) {
            Advised advised = (Advised) bean;
            result = advised.getTargetSource().getTarget();
        }
        return result;
    }
}