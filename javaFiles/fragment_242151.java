public class LoggingConstructorInterceptor implements ConstructorInterceptor {

    private static final Logger LOG
            = Logger.getLogger(LoggingConstructorInterceptor.class.getName());

    @Override
    public Object construct(ConstructorInvocation invocation) throws Throwable {
        Constructor ctor = invocation.getConstructor();
        LOG.log(Level.INFO, "Creating: {0}", ctor.getDeclaringClass().getName());

        // returned instance from constructor invocation.
        Object instance = invocation.proceed();
        LOG.log(Level.INFO, "Created Instance: {0}", instance.toString());

        return instance;
    }
}