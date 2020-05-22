public class LogInterceptor implements MethodInterceptor, Ordered{

    @Transactional
    public final Object invoke(MethodInvocation invocation) throws Throwable {
        Object r = invocation.proceed();
        Log l = LogThreadLocal.get();
        logService.save(l);
        return r;
    }
}