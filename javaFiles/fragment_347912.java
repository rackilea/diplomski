import java.util.Random;

public class VarTest {
    private static final Random rng = new Random();
    private static final String example = Integer.toString(rng.nextInt());

    public static void main(String[] args) {
        System.out.println(example);
        System.out.println(rng.nextInt());
        System.out.println(rng.nextInt());
        System.out.println(example);
    }
}