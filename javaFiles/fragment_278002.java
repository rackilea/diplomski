public class Diner {

    public void findSeat() {
        System.out.println("findSeat");
    }
    public void placeOrder() {
        System.out.println("placeOrder");
    }

    public static void main(String[] args) throws InterruptedException {
        final ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        final CountDownLatch done = new CountDownLatch(1);

        final Diner diner = new Diner();

        exec.schedule(new Runnable() {
            public void run() {
                diner.findSeat();
            }
        }, 2, TimeUnit.SECONDS);

        exec.schedule(new Runnable() {
            public void run() {
                diner.placeOrder();
            }
        }, 4, TimeUnit.SECONDS);


        exec.schedule(new Runnable() {
            public void run() {
                done.countDown();
            }
        }, 6, TimeUnit.SECONDS);

        done.await();
        exec.shutdown();
        System.out.println("done");
    }
}