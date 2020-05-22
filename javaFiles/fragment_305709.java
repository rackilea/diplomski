// A simple lock example.
import java.util.concurrent.locks.*;

class LockDemo {
    public static void main(String args[]) {
        ReentrantLock lock = new ReentrantLock();
        LockThread lt1 = new LockThread(lock, "A");
        LockThread lt2 = new LockThread(lock, "B");
        Thread t1 = new Thread(lt1);
        Thread t2 = new Thread(lt2);
        t1.start();
        t2.start();
    }
}

// A shared resource.
class Shared {
    static int count = 0;
}

// A thread of execution that increments count.
class LockThread implements Runnable {
    String name;
    ReentrantLock lock;

    LockThread(ReentrantLock lk, String n) {
        lock = lk;
        name = n;       
    }

    public void run() {
        System.out.println("Starting " + name);
        try {
            // First, lock count.
            System.out.println(name + " is waiting to lock count.");
            lock.lock();
            System.out.println(name + " is locking count.");
            Shared.count++;
            System.out.println(name + ": " + Shared.count);
            // Now, allow a context switch -- if possible.
            System.out.println(name + " is sleeping.");
            Thread.sleep(1000);
        } catch (InterruptedException exc) {
            System.out.println(exc);
        } finally {
            // Unlock
            System.out.println(name + " is unlocking count.");
            lock.unlock();
        }
    }
}