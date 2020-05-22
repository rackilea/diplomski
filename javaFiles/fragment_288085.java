public class MyThread extends Thread {
    private String name, msg;
    private int interval; // to specify the period to be used to take lock. Main thread needs to do it for every iteration whereas childthread should do it for 2 iterations
    private static Object lock = new Object(); // to use wait and notify mechanism to get the desired output
    private static boolean done = false; // to make sure that if the child thread is done with its tasks then main thread need not wait

    public MyThread(String name, int interval) {
        this.name = name; 
        this.interval = interval;
    }

    public void run() {
        int count = 0;
        synchronized (lock) {

            System.out.println(name+" Thread : starts its execution");

            for (int i = 5; i > 0; i--) {

                System.out.println(name + " says: " +i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ie) {}

                // Main thread waits for every iteration
                // Child thread waits for every 2 iterations
                if(!done && ++count % interval == 0) {
                    lock.notifyAll();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            // Once child thread is done with its iterations, main thread need not wait anymore hence set done to true
            done = true;
            // to make sure that if the main thread is waiting then give it a signal to finish its tasks with no more waiting
            lock.notifyAll();
            System.out.println(name + " finished execution");
        }
    }

    public static void main(String[] args) {
        MyThread mt1 = new MyThread("Main Thread",1);
        MyThread mt2 = new MyThread("Child Thread",2);

        mt1.start();
        mt2.start();

    }

}