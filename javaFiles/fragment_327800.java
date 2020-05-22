public class ThreadTest {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("I'm still here!");
            }
        });
        // uncomment following line to test with daemon thread
        //thread.setDaemon(true);
        thread.start();

        System.out.println("Finished!");
    }

}