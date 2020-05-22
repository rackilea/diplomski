public class TimerInvocation implements Invocation {
    @Override
    public Object invoke(Object callee, Method method, Object[] args, InvocationChain chain) {
        long start_time = System.nanoTime();
        chain.invoke(callee, method, args);
        long end_time = System.nanoTime();

        System.out.println("Timer: excution took " + (end_time - start_time) / 1e6 + "ms");

        return null;
    }
}