public class Main {

    public static void main(final String[] args) throws InterruptedException {
        boolean run = true;
        CountDownLatch latch = new CountDownLatch(1);
        final MyClass myClass = new MyClass(latch);

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                myClass.doMyWork(args);
            }
        });

        t.start();
        latch.await();
        t.join();

    }

}

class MyClass {
    private CountDownLatch latch;

    public MyClass(CountDownLatch latch) {
        this.latch = latch;
    }

    public void doMyWork(String[] args) {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
        latch.countDown();
    }
}