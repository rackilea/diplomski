public class LoggingInvocation implements Invocation {
    @Override
    public Object invoke(Object callee, Method method, Object[] args, InvocationChain chain) {
        chain.invoke(callee, method, args);
        Logger.getLogger(this.getClass().getCanonicalName()).info(method.getName() + "() execution logged!");
        return null;
    }
}