@Component
public class SynchronousRpcProxyFactory
                 implements FactoryBean<SynchronousRpcProxy> {

    @Autowired
    private MyObj1 notNull1;

    @Autowired
    private MyObj1 notNull2;

    @Autowired(required = false)
    private MyNullable canBeNull;

    @Override
    public SynchronousRpcProxy getObject() throws Exception {
        return new SynchronousRpcProxy(notNull1, notNull2, canBeNull);
    }

    @Override
    public Class<?> getObjectType() {
        return SynchronousRpcProxy.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}