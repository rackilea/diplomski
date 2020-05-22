public class MyLatchTest {
    public static void main(String[] args) {
        int num = 10;
        MyLatch countDownLatch = new MyLatch(num);
        for(int i = 0; i < num; i++) {
            Thread t = new Thread(() ->
            {
                try {
                    System.out.println("CountDownLatch: in thread..");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("CountDownLatch: one thread finished..");
                countDownLatch.countDown();
            });
            t.start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("CountDownLatch: out thread..");
    }
}