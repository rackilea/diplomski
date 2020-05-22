package lock;

public class LockTest {

    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

    public static void main(String[] args) {
        lock.readLock().lock();
        System.out.println(Thread.currentThread().getName()+": read hold "+lock.getReadHoldCount()+" read lock "+lock.getReadLockCount());
        new Th().start();
        synchronized (LockTest.class) {
            try { LockTest.class.wait(); } catch (InterruptedException e) { }
        }
        lock.readLock().unlock();
        System.out.println(Thread.currentThread().getName()+": unlocked read lock. Read hold "+lock.getReadHoldCount()+" read lock "+lock.getReadLockCount()+". Getting write lock");
        lock.writeLock().lock();
        System.out.println(Thread.currentThread().getName()+": got write lock. Unlocking (=>Thread dump #3)"); // Take thead dump #3 here ("main" has a write lock, "other" has died)
        lock.writeLock().unlock();
    }

    static class Th extends Thread {
        Th() { super("other"); }

        public void run() {
            System.out.println(Thread.currentThread().getName()+": read hold "+lock.getReadHoldCount()+" read lock "+lock.getReadLockCount());
            if (!lock.writeLock().tryLock())
                System.out.println(Thread.currentThread().getName()+": cannot lock write");
            else {
                System.out.println(Thread.currentThread().getName()+": lock write taken");
                lock.writeLock().unlock();
            }
            System.out.println(Thread.currentThread().getName()+": trying to unlock read lock");
            try {
                lock.readLock().unlock();
                System.out.println(Thread.currentThread().getName()+": successfully unlocked read lock. Read hold "+lock.getReadHoldCount()+" read lock "+lock.getReadLockCount());
            } catch (IllegalMonitorStateException e) {
                System.out.println(Thread.currentThread().getName()+": cannot unlock read lock: "+e.getMessage());
            }
            synchronized (LockTest.class) {
                System.out.println(Thread.currentThread().getName()+": notifying write lock take (=>Thread dump #1)");
                LockTest.class.notify(); // Take thead dump #1 here ("main" has a read lock)
            }
            System.out.println(Thread.currentThread().getName()+": locking write lock");
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName()+": unlocking write lock (=>Thread dump #2)"); // Take thead dump #2 here ("other" has a write lock)
            lock.writeLock().unlock();
        }
    }
}