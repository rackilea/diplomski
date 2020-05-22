package foo1;

import java.util.concurrent.TimeUnit;

public class StringProducer {
    private static final int MAX = 10;
    private static final long SLEEP_TIME = 400;

    public static void main(String[] args) {
        System.out.println("Start");
        for (int i = 0; i < MAX; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("At index: " + i);
            try {
                TimeUnit.MILLISECONDS.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("End");
    }
}