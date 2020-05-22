import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NumberCounter {

    private final ExecutorService pool = Executors.newFixedThreadPool(2);
    private final BlockingQueue<Integer> queue = new ArrayBlockingQueue(100);

    public void startCounter(int max, int workers) {
        // Create multiple tasks to add numbers. Each task submits the result
        // to the queue.
        int increment = max / workers;
        for (int worker = 0; worker < workers; worker++) {
            Runnable task = createProducer(worker * increment, (worker + 1) * increment);
            pool.execute(task);
        }

        // Create one more task that will consume the numbers, adding them up
        // and printing the results.
        pool.execute(new Runnable() {

            @Override
            public void run() {
            int sum = 0;

            while (true) {
                try {
                Integer result = queue.take();
                sum += result;
                System.out.println("New sum is " + sum);
                } catch (InterruptedException e) {
                e.printStackTrace();
                }
            }

            }
        });

    }

    private Runnable createProducer(final int start, final int stop) {
        return new Runnable() {

            @Override
            public void run() {
            System.out.println("Worker started counting from " + start + " to " + stop);
            int count = 0;
            for (int i = start; i < stop; i++) {
                count += i;
                }
                queue.add(count);
            }

        };
    }

    public static void main(String[] args) throws InterruptedException {
        NumberCounter counter = new NumberCounter();
        counter.startCounter(10000, 5);
    }

}