public class Lesson6 {
    private static volatile long value = 0L;

    public static void main(String[] args) throws InterruptedException {
        final Object locked = new Object();
        Thread inc = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100_000; i++) {
                    synchronized (locked){
                        ++value;
                    }
                }
            }
        });
        inc.start();

        Thread dec = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100_000; i++) {
                    synchronized (locked){
                        --value;
                    }
                }
            }
        });
        dec.start();

        inc.join();
        dec.join();

        System.out.println(value);
    }
}