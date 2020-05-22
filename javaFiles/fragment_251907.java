public class Main {

    public static final SyncNotsynced sn = new SyncNotsynced();

    public static void main(String[] args){
        Thread t1 = new Thread(sn::synced);
        Thread t2 = new Thread(sn::notsynced);
        t1.start();
        t2.start();
    }

    public static class SyncNotsynced {

        public synchronized void synced(){
            System.out.println(Thread.currentThread().getName() + " enter synced");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(Thread.currentThread().getName() +  " exit synced");
        }

        public void notsynced(){
            System.out.println(Thread.currentThread().getName() + " enter notsynced");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(Thread.currentThread().getName() +  " exit notsynced");
        }
    }
}