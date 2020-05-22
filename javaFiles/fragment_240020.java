import java.util.concurrent.CountDownLatch;

public class MyClass {
    private String string;

    private final CountDownLatch latch = new CountDownLatch(1);

    public void onData(String value) {
        this.string = value;
        latch.countDown();
    }

    public void callOnData(/*some param*/) {
        new Thread(() -> {
            try {
                Thread.sleep(100L);
            }
            catch (InterruptedException e) {
            }
            onData("hello");
        }).start();
    }

    public String whatIwantTo() throws InterruptedException {
        callOnData();
        latch.await();
        return this.string;
    }

    public static void main(String[] args) throws InterruptedException {
        MyClass m = new MyClass();
        System.out.println(m.whatIwantTo());
    }
}