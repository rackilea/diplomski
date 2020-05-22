import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Primes {

    private BlockingQueue<Integer> candidateQueue;

    private BlockingQueue<Integer> primesQueue;

    private Set<Integer> primeNumbers;

    public Primes() {
        candidateQueue = new LinkedBlockingQueue<Integer>();
        primesQueue = new LinkedBlockingQueue<Integer>();
        primeNumbers = new HashSet<Integer>();
    }

    public void findPrimesInRange(int smallest, int biggest) {

        NumberGenerator a = new NumberGenerator(smallest, biggest,
                candidateQueue);
        Thread threadA = new Thread(a);
        threadA.start();

        PrimalityChecker p1 = new PrimalityChecker(candidateQueue, primesQueue);
        Thread threadP1 = new Thread(p1);
        threadP1.start();

        PrimalityChecker p2 = new PrimalityChecker(candidateQueue, primesQueue);
        Thread threadP2 = new Thread(p2);
        threadP2.start();

        PrimesPrinter pp = new PrimesPrinter(primesQueue, primeNumbers);
        Thread threadPP = new Thread(pp);
        threadPP.start();

        while (true) {
            try {
                Thread.sleep(1000);
                if (candidateQueue.size() == 0 && primesQueue.size() == 0) {
                    threadA.interrupt();
                    threadP1.interrupt();
                    threadP2.interrupt();
                    threadPP.interrupt();
                    break;

                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        Primes p = new Primes();
        p.findPrimesInRange(2, 100);

    }
}