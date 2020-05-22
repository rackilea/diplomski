import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Statistics_19711 {

  static Scanner input = new Scanner(System.in);

  public static void generateRandoms(int[] numbers, int low, int high, int count) { // semi-done
    // Generate random numbers within the range [low, high] and store them in
    // numbers array
    low = 1;
    System.out.println("Creating 500 random numbers from 1 to " + count + ":");
    Random rand = new Random();
    if (high > 0 && high <= 100000) {
      for (int i = 0; i < numbers.length; i++) {
        numbers[i] = rand.nextInt(high) + low;
        System.out.print(i + ((i - (0 - 1)) % 10 == 0 ? "\n" : " "));
      }
    } else {
      System.out.println("Input outside of range. Try Again.");
    }
    Arrays.sort(numbers);
  }

  public static void main(String[] args) {
    // the main() method should call the above methods. The main() method is
    // then only method that does the input and output operation.
    System.out
        .println("This program creates random numbers and calculates some statistics.");
    System.out
        .println("Enter the upper limit of all generated random numbers:");
    int high = input.nextInt();
    System.out.println("Enter the count(maximum of 100000) of random numbers:");
    int count = input.nextInt();
    int[] numbers = new int[count];
    int[] generatedRandoms = generateRandoms(numbers, 1, high, count);
    System.out.println(Arrays.toString(generatedRandoms));
  }
}