import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String[] args) {

        // Fixed thread number
        ExecutorService service = Executors.newFixedThreadPool(10);

        // Or un fixed thread number
        // The number of threads will increase with tasks
        // ExecutorService service = Executors.newCachedThreadPool(10);

        List<Object> objects = new ArrayList<>();
        for (Object o : objects) {
            service.execute(new MyTask(o));
        }

        // shutdown
        // this will get blocked until all task finish
        service.shutdown();
        try {
            service.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class MyTask implements Runnable {
        Object target;

        public MyTask(Object target) {
            this.target = target;
        }

        @Override
        public void run() {
            // business logic at here
        }
    }
}