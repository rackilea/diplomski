import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TrafficLight<T> {

    private ReentrantLock lock = new ReentrantLock(true);
    private Condition switched = lock.newCondition();
    private int registered;
    private int maxBeforeYield = 20;
    private T state;

    public void acquire(T t) throws InterruptedException {
        lock.lock();
        try {
            while ((state != null && !state.equals(t)) || maxBeforeYield == 0) {
                switched.await();
            }
            if (state == null) {
                state = t;
            }
            registered++;
            maxBeforeYield--;
        } finally {
            lock.unlock();
        }
    }

    public void release() {
        lock.lock();
        try {
            registered--;
            if (registered == 0) {
                state = null;
                maxBeforeYield = 20;
                switched.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }
}