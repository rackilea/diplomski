import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    private ExecutorService executor;
    private Socket socket;
    private AtomicBoolean running = new AtomicBoolean(true);

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.run();
    }

    private Main() throws IOException {
        executor = Executors.newCachedThreadPool();
        socket = new Socket("localhost", 1234);
    }

    private void run() throws IOException {
        BlockingQueue<String> q = new SynchronousQueue<>();
        Producer producer = new Producer(socket, q);
        Consumer consumer = new Consumer(q);

        // Start the producer. When it ends call stop
        CompletableFuture.runAsync(producer, executor).whenComplete((status, ex) -> stop());
        // Start the consumer.
        CompletableFuture.runAsync(consumer, executor);
        // Add a shutdown hook to stop everything on break
        Runtime.getRuntime().addShutdownHook(new Thread(this::stop));
    }

    private void stop() {
        if (running.compareAndSet(true, false)) { // only once
            // Close the socket to unblock the producer
            try {
                socket.close();
            } catch (IOException e) {
                // ignore
            }

            // Interrupt tasks
            executor.shutdownNow();
            try {
                // Give tasks some time to clean up
                executor.awaitTermination(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                // ignore
            }
        }
    }

    static class Producer implements Runnable {
        private BufferedReader in;
        private BlockingQueue<String> q;

        public Producer(Socket socket, BlockingQueue<String> q) throws IOException {
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.q = q;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String data = in.readLine();
                    if (data == null) {
                        break;
                    }
                    q.put(data);
                }
            } catch (InterruptedException | IOException e) {
                // Fall through
            }
            System.err.println("Producer done");
        }
    }

    static class Consumer implements Runnable {
        private BlockingQueue<String> q;

        public Consumer(BlockingQueue<String> q) {
            this.q = q;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(q.take());
                }
            } catch (InterruptedException e) {
                // done
            }
            System.err.println("Client done");
        }
    }
}