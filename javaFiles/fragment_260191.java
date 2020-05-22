import java.util.Random;

public class test {

    private static final Random generator = new Random();

    public static int dice() {
        return generator.nextInt(6) + 1;
    }

    public static void main(String[] args) {
        int roll1 = dice();
        int roll2 = dice();
        System.out.println(roll1);
        System.out.println(roll2);
    }
}