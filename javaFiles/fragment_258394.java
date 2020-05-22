public class Koordinator {

    private int[] forks;
    private int anzahlPhilosophen;
    private ReentrantLock lock = new ReentrantLock();
    private Condition[] readyToEatCondition;

    public Koordinator(int anzahlPhilosophen) {
        this.anzahlPhilosophen = anzahlPhilosophen;
        forks = new int[anzahlPhilosophen];
        readyToEatCondition = new Condition[anzahlPhilosophen];
        for (int i = 0; i < anzahlPhilosophen; i++) {
            forks[i] = 2;
            readyToEatCondition[i] = lock.newCondition();
        }
    }

    public void takeForks(int id) throws InterruptedException {
       this.lock.lock();
       try {
            while (forks[id] != 2) {
                 readyToEatCondition[id].await();
            }
            forks[(id + 1) % anzahlPhilosophen] = forks[(id + 1) % anzahlPhilosophen] - 1;
            forks[(id - 1 + anzahlPhilosophen) % anzahlPhilosophen] = forks[(id - 1 + anzahlPhilosophen) % anzahlPhilosophen] - 1;
        } finally {
            this.lock.unlock();
        }
    }

    public void releaseForks(int id) {
        this.lock.lock();
        try {
            forks[(id + 1) % anzahlPhilosophen] = forks[(id + 1) % anzahlPhilosophen] + 1;
            forks[(id - 1 + anzahlPhilosophen) % anzahlPhilosophen] = forks[(id - 1 + anzahlPhilosophen) % anzahlPhilosophen] + 1;

            if (forks[(id + 1) % anzahlPhilosophen] == 2) {
                readyToEatCondition[(id + 1) % anzahlPhilosophen].signalAll();
            }
            if (forks[(id - 1 + anzahlPhilosophen) % anzahlPhilosophen] == 2) {
                readyToEatCondition[(id - 1 + anzahlPhilosophen) % anzahlPhilosophen].signalAll();
            }
        } finally {
            this.lock.unlock();
        }
    }
}