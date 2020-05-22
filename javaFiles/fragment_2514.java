//Thread Safe Callable implementation
public class MyThreadSafeCallable implements Callable<String> {

    private AtomicInteger i = new AtomicInteger(0);

    @Override
    public String call() throws Exception {
         int value = i.incrementAndGet();
         System.out.println(value);
         return String.valueOf(value);
    }
}