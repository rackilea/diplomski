import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.Optional;

public class Main {

    static class Producer implements Runnable {

        private final BlockingQueue<Optional<Integer>> sharedQueue;
        private int threadNo;

        public Producer(BlockingQueue<Optional<Integer>> sharedQueue, int threadNo) {
            this.threadNo = threadNo;
            this.sharedQueue = sharedQueue;
        }

        @Override
        public void run() {
            for(int i=1; i<= 5; i++){
                try {
                    Integer number = i+(10*threadNo);
                    System.out.println("Produced:" + number + ":by thread:"+ threadNo);
                    sharedQueue.put(Optional.of(number));
                } catch (Exception err) {
                    err.printStackTrace();
                }
            }
            // Signal consumer to stop.
            try {
                sharedQueue.put(Optional.empty());
            } catch (Exception err) {
                err.printStackTrace();
            }
        }
    }

    static class Consumer implements Runnable {

        private final BlockingQueue<Optional<Integer>> sharedQueue;
        private int threadNo;

        public Consumer (BlockingQueue<Optional<Integer>> sharedQueue,int threadNo) {
            this.sharedQueue = sharedQueue;
            this.threadNo = threadNo;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Optional<Integer> num = sharedQueue.take();
                    if (!num.isPresent()) {
                        System.out.println("Consumed TERMINATOR");
                        break;
                    }
                    Thread.sleep(100);
                    System.out.println("Consumed: " + num.get() + ":by thread:" + threadNo);
                } catch (Exception err) {
                   err.printStackTrace();
                }
            }
        }
    }

    private static void shutdownService(final ExecutorService es) {
        es.shutdown();
        try {
            if (!es.awaitTermination(5, TimeUnit.SECONDS)) {
                es.shutdownNow();
            }
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(final String args[]) {

        BlockingQueue<Optional<Integer>> sharedQueue = new LinkedBlockingQueue<Optional<Integer>>();

        ExecutorService pes = Executors.newFixedThreadPool(1);
        ExecutorService ces = Executors.newFixedThreadPool(1);

        Future consumed = ces.submit(new Consumer(sharedQueue, 1));
        Future produced = pes.submit(new Producer(sharedQueue, 1));

        System.out.println("Submitted...");
        try {
            produced.get();
            System.out.println("Producer finished...");
            consumed.get();
            System.out.println("Consumer finished...");
        } catch (final Exception e) {
            throw new RuntimeException(e);
        } finally {
            shutdownService(ces);
            shutdownService(pes);
        }
        System.out.println("Done...");
    }

}