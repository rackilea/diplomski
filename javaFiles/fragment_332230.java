import java.util.concurrent.ThreadLocalRandom;

public class MyClass {
    public static void main(String args[]) {
        System.out.println(ThreadLocalRandom.current().nextDouble(0.5, 0.6));
    }
}