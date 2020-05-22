import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class PrimeRunnable implements Runnable {

    // Static Util
    public static List<PrimeRunnable> runningThreads = new CopyOnWriteArrayList<PrimeRunnable>();
    public static long[] primes;
    public static int nextFreeIndex = 1;
    public static long nextPossiblePrime = 3;

    // Object specific
    private long numberToCheck;
    private Thread primeThread;
    private String threadName;
    private long threadID;

    public PrimeRunnable() {
        numberToCheck = nextPossiblePrime;
        increaseNextPossiblePrime();

        threadName = "ThreadToCheck" + numberToCheck;
        threadID = numberToCheck;

        runningThreads.add(this);
    }

    @Override
    public void run() {
        boolean isPrime = true;
        double sqrtOfPossiblePrime = Math.sqrt(numberToCheck);

        long lastDevider = 0;

        for (int index = 0; index < nextFreeIndex; index++) {
            lastDevider = primes[index];
            if (numberToCheck % primes[index] == 0) {
                isPrime = false;
                break;
            }
            if (primes[index] > sqrtOfPossiblePrime) {
                break;
            }
        }

        while (lastDevider < sqrtOfPossiblePrime) {
            lastDevider += 1;

            if (numberToCheck % lastDevider == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            // Wait for lower Threads.

            for (PrimeRunnable runnable : runningThreads) {
                if (runnable.getThreadID() < this.getThreadID()) {
                    try {
                        runnable.primeThread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            primes[nextFreeIndex] = numberToCheck;
            increaseNextFreeIndex();
            System.out.println(numberToCheck);
        }
        runningThreads.remove(this);
    }

    public void start() {
        if (primeThread == null) {
            primeThread = new Thread(this, threadName);
        }

        primeThread.start();
    }

    public void reset() {
        numberToCheck = nextPossiblePrime;
        increaseNextPossiblePrime();

        threadName = "ThreadToCheck" + numberToCheck;
        threadID = numberToCheck;

        // No need to readd into runningThread, since we only manipulate an
        // already existing object.
        primeThread = new Thread(this, threadName);
        primeThread.start();
    }

    public static void setUpperBorder(int upperBorder) {
        if (primes == null) {
            primes = new long[upperBorder];
            primes[0] = 2;
        } else {
            System.err
                    .println("You are not allowed to set the upper border while running.");
        }
    }

    public long getNumberToCheck() {
        return numberToCheck;
    }

    private void increaseNextPossiblePrime() {
        nextPossiblePrime += 2;
    }

    private void increaseNextFreeIndex() {
        nextFreeIndex += 2;
    }

    public long getThreadID() {
        return threadID;
    }

    public boolean isAlive() {
        return primeThread.isAlive();
    }
}