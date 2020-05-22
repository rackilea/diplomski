import java.util.concurrent.locks.ReentrantLock;
import java.lang.Thread;

public class LockTest {

    public static void main(String args[]){
        TestClass testClass = new TestClass();

        Thread thread0 = new Thread () {
            public void run () {
                testClass.testLock();
            }
        };
        Thread thread1 = new Thread () {
            public void run () {
                testClass.testLock();
            }
        };
        Thread thread2 = new Thread () {
            public void run () {
                testClass.testLock();
            }
        };

        thread0.start();
        thread1.start();
        thread2.start();

    }

    public static class TestClass{
        ReentrantLock reentrantLock = new ReentrantLock();

        public void testLock(){
            if (reentrantLock.tryLock()) {
                try {
                    System.out.println("Locking");
                    System.out.println(Thread.currentThread().getName() + " will sleep");
                    Thread.sleep(8000);
                    System.out.println(Thread.currentThread().getName() + " has woken up from sleep!!");
                } catch (InterruptedException i) {
                    System.out.println("Interrupted during sleep");
                } finally {
                    System.out.println("Unlocking");
                    reentrantLock.unlock();
                    System.out.println("Notifying");
                    synchronized (reentrantLock) {
                        reentrantLock.notifyAll();
                    }
                }
            } else {
                synchronized (reentrantLock) {
                    while(reentrantLock.isLocked()) {
                        try {
                            System.out.println(Thread.currentThread().getName() + " will wait");
                            reentrantLock.wait();
                            System.out.println(Thread.currentThread().getName() + " has woken up from wait!!");
                        } catch (InterruptedException i) {
                            System.out.println("Interrupted during wait");
                        }
                    }
                }
            }
            System.out.println(Thread.currentThread().getName() + " has reached the end.");
        }

    }

}