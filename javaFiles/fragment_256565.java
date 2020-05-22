import java.time.LocalDateTime;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("start");

        new Thread(() -> {
            try {
                while (true) {
                    System.out.println(LocalDateTime.now() + " - running");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(1000);
        System.out.println("end");
    }
}