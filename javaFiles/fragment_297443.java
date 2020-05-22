import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {
    private static class CallableExample implements Callable<Integer> {
        private final Object foo;

        private CallableExample(Object foo) {
            this.foo = foo;
        }

        @Override
        public Integer call() {
            // do something and return it
            return foo.hashCode();
        }

    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService e = Executors.newFixedThreadPool(2);
        Future<Integer> f1 = e.submit(new CallableExample("foo"));
        Future<Integer> f2 = e.submit(new CallableExample("bar"));

        System.out.println(f1.get());
        System.out.println(f2.get());

        e.shutdown();
    }
}