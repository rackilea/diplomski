class Thr extends Thread
{
    Thr () throws InterruptedException
    {
        final Object lock = new Object ();

        Thread t1 = new Thread() {
            public void run()
            {
                    try {
                        synchronized (lock) {
                            lock.wait();
                        }
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }

                    System.out.println("hey 1");
            }
        };

        Thread t2 = new Thread() {
            public synchronized void run()
            {
                    try {
                        synchronized (lock) {
                            lock.wait();
                        }
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }

                    System.out.println("hey 2");
            }
        };

        t1.start();
        t2.start();
        synchronized (lock) {
            lock.notifyAll ();
        }
    }

    public static void main(String args[]) throws InterruptedException
    {
        new Thr();
    }
}