public class WaitTest {

    static class Waiter implements Runnable{

        @Override
        public void run() {
            System.out.println("Waiting");
            try {
                synchronized(this){
                    this.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Running");
        }

    }

    static class Notifier implements Runnable{

        Object locked;

        public Notifier(Object locked){
            this.locked = locked;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized(locked){
                locked.notifyAll();
            }

        }

    }

    public static void main(String[] args){

        Waiter waiter = new Waiter();
        Notifier notifier = new Notifier(waiter);

        Thread t1 = new Thread(waiter);
        Thread t2 = new Thread(notifier);

        t1.start();
        t2.start();
    }

}