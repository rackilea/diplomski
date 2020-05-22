import java.util.Iterator;
import java.util.concurrent.BlockingQueue;

public class PrimalityChecker implements Runnable {
    private final BlockingQueue<Integer> candidateQueue;

    private final BlockingQueue<Integer> primesQueue;

    public PrimalityChecker(BlockingQueue<Integer> candidates,
            BlockingQueue<Integer> primes) {
        candidateQueue = candidates;
        primesQueue = primes;
    }

    public void run() {
        Iterator<Integer> itr = candidateQueue.iterator();

        while (itr.hasNext()) {
            Integer Queue = null;
            try {
                Queue = candidateQueue.take();
            } catch (InterruptedException e1) {
                System.out.println("PrimalityChecker Thread interruped");
                return;
            }
            if (isPrime(Queue)) {
                primesQueue.add(Queue);

            }
        }

    }

    public static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}