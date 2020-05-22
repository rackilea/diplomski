import java.util.Set;
import java.util.concurrent.BlockingQueue;

public class PrimesPrinter implements Runnable {
    private final BlockingQueue<Integer> primesQueue;

    private final Set<Integer> primesSet;

    public PrimesPrinter(BlockingQueue<Integer> primes, Set<Integer> primesSet) {
        primesQueue = primes;
        this.primesSet = primesSet;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            while (primesQueue.size() > 0) {
                Integer Queue;
                try {
                    Queue = primesQueue.take();
                    System.out.println(Queue);

                    primesSet.add(Queue);
                }

                catch (InterruptedException e) {
                    System.out.println("Primes Printer Interrupted");
                    e.printStackTrace();
                }

            }
        }
    }
}