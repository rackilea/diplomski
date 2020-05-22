package ravi.tutorial.java.threads;

public class TestThreads {

    /**
     * @param args
     */
    public static void main(String[] args) {
        CommonLock commonLock = new CommonLock();
        Thread1 thread1 = new Thread1(commonLock);
        Thread2 thread2 = new Thread2(commonLock);
        thread1.start();
        thread2.start();
    }
}

/*
 * Common monitor lock between both threads, used for communication using wait
 * notify.
 */
class CommonLock {

}

// Extending Thread instead of Runnable as its just a test
class Thread1 extends Thread {

    private CommonLock commonLock;

    public Thread1(CommonLock commonLock) {
        this.commonLock = commonLock;
    }

    public void run() {
        System.out.println("Started thread 1");
        System.out.println("waiting thread 1");
        try {
            // TO wait on commonLock, first need to get lock on commonLock. SO
            // put synchronized block of commonLock.
            synchronized (commonLock) {
                commonLock.wait();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("DONE waiting thread 1 as I got notification from THread 2");
    }

}

class Thread2 extends Thread {

    private CommonLock commonLock;

    public Thread2(CommonLock commonLock) {
        this.commonLock = commonLock;
    }

    public void run() {
        System.out.println("Running thread 2");

        try {
            System.out.println("Sleeping thread 2");
            // Just take gap of 2 sec before notifying.
            Thread.sleep(2000);

            // TO notify on commonLock, first need to get lock on commonLock. SO
            // put synchronized block of commonLock.
            synchronized (commonLock) {
                System.out.println("Notifying thread 2");
                commonLock.notifyAll();
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}