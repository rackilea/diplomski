import java.util.Random;

public class RandomNumberGenerator {

    private static final Random RANDOM = new Random();


    private RandomNumberGenerator() {

    }

    //Usage: RandomNumberGenerator.getRandomNumber(10000);
    public static int getRandomNumber(int max) {
        return RANDOM.nextInt(max);
    }
}