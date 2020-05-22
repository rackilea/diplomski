import java.util.Random;
import java.util.Scanner;

public class TestingCenter {

private static final Random random = new Random();

public static void main(final String[] args) {

    System.out.println("How many times should I roll the dice? ");
    int answer = 0;
    try (Scanner scanner = new Scanner(System.in)) {
        answer = scanner.nextInt();
    }
    final int[] results = new int[11];
    for (int x = 0; x < answer; x++) {
        results[amount() - 2]++;
    }
    System.out.println(String.format("Results for %s dice rolls ", answer));
    for (int i = 0; i < 11; i++) {
        System.out.println(String.format("%s was rolled %s times", i + 2, results[i]));
    }
}

    public static int amount() {
        return random.nextInt(6) + random.nextInt(6) + 2;

    }
}