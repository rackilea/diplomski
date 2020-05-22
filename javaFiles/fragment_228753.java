public class Race
{
    static final int ITERATIONS = 10000;
    static int counter;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("start");
        Thread first = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < ITERATIONS; i++) {
                    counter++;
                }
            }
        });
        Thread second = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < ITERATIONS; i++) {
                    counter++;
                }
            }
        });
        first.start();
        second.start();
        first.join();
        second.join();
        System.out.println("Counter " + counter + " should be " + (2 * ITERATIONS));
    }
}

>>> Counter 12325 should be 20000