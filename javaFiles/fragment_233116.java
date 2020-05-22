import java.util.Random;

public class Test {
    public static void main(String[] args) throws Exception {

        Random rng = new Random();
        int total = 0;
        for (int i = 0; i < 1000000; i++) {
            total += rng.nextInt(2);
        }
        System.out.println("Total: " + total);
    }
}