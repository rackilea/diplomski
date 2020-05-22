import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingRef<V> {

  private final Lock lock = new ReentrantLock(true);

  private final Condition signal = lock.newCondition();

  private volatile V value;

  public BlockingRef() {
    this(null);
  }

  public BlockingRef(V initialValue) {
    this.value = initialValue;
  }

  public final void set(V value) {
    lock.lock();
    try {
      this.value = value;
      signal.signalAll();
    } finally {
      lock.unlock();
    }
  }

  public final V get() throws InterruptedException {
    V result = value;
    if (result == null) {
      lock.lockInterruptibly();
      try {
        for (result = value; result == null; result = value)
          signal.await();
      } finally {
        lock.unlock();
      }
    }
    return result;
  }

  public final V get(long time, TimeUnit unit) 
    throws TimeoutException, InterruptedException 
  {
    V result = value;
    if (result == null) {
      long start = System.nanoTime();
      if (!lock.tryLock(time, unit)) throw new TimeoutException();
      try {
        time = unit.toNanos(time);
        for (result = value; result == null; result = value) {
          long wait = time - (System.nanoTime() - start);
          if (wait <= 0) throw new TimeoutException();
          signal.await(wait, TimeUnit.NANOSECONDS);
        }
      } finally {
        lock.unlock();
      }
    }
    return result;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

}