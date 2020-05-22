import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class RunUntilKeyPressed {
    static AtomicBoolean hasUserPressedKey = new AtomicBoolean(false);

    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            Scanner scan = new Scanner(System.in);
            System.out.println(scan.next());
            hasUserPressedKey.set(true);
            scan.close();
        });
        t.start();

        while(!hasUserPressedKey.get()) {
           System.out.println(hasUserPressedKey);
        }
    }
}