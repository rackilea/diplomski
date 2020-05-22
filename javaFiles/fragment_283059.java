import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CompletionServiceExample {


    private static Logger LOGGER = Logger.getLogger("CompletionServiceExample");

    public static void main(String[] args) throws InterruptedException {

        CompletionServiceExample completionServiceExample = new CompletionServiceExample();
        completionServiceExample.doTheWork();
    }

    private void doTheWork() throws InterruptedException {

        final ExecutorService executorService = Executors.newFixedThreadPool(2);
        final CompletionService<Base> completionService = new ExecutorCompletionService<>(executorService);


        completionService.submit(new FooBase());
        completionService.submit(new BarBase());

        int total_tasks = 2;

        for (int i = 0; i < total_tasks; ++i) {

            try {
                final Future<Base> value = completionService.take();
                Base base = value.get();
                if (base instanceof FooBase) {
                    int myInteger = ((FooBase) base).getValue();
                    System.out.println("received value: " + myInteger);
                }
                if (base instanceof BarBase) {
                    boolean myBoolean = ((BarBase) base).isValue();
                    System.out.println("received value: " + myBoolean);
                }

            } catch (ExecutionException e) {
                LOGGER.log(Level.WARNING, "Error while processing task. ", e);
            } catch (InterruptedException e) {
                LOGGER.log(Level.WARNING, "interrupted while waiting for result", e);
            }
        }


        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.SECONDS);

    }
}

class Base {
}

class FooBase extends Base implements Callable<Base> {

    private int value;

    @Override
    public Base call() throws Exception {
        Thread.sleep(5000);
        value = 10;
        return this;
    }

    public int getValue() {
        return value;
    }
}

class BarBase extends Base implements Callable<Base> {

    private boolean value;

    @Override
    public Base call() throws Exception {
        Thread.sleep(1000);
        value = false;
        return this;
    }

    public boolean isValue() {
        return value;
    }
}