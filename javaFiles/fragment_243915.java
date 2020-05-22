public class LoggingAOP implements MethodInterceptor {

    @Inject
    private Provider<SomethingThatTakesALongTimeToInit> provider;

    public Object invoke(MethodInvocation invocation) throws Throwable {
        provider.get()...
        System.out.println("start");
        long start = System.currentTimeMillis();
        Object value =  invocation.proceed();
        System.out.println("end took: " + (System.currentTimeMillis() - start));
        return value;
    }
}