import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Random RND_GEN = new Random();

    public int[] createNum(int[] randomNumbers) {
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = RND_GEN.nextInt(10) + 1;
        }

        return randomNumbers;
    }

    public void printNum(int[] randomNumbers){
        for (int i = 0; i < randomNumbers.length; i++) {
            System.out.println("Number " + i + " : " + randomNumbers[i]);
        }
    }

    public int findNumInstancesInArray(int[] array, int numLookingFor) {
        int count = 0;

        for(int i : array) {
            if (i == numLookingFor) {
                count++;
            }
        }

        return count;
    }

    public void run() {
        Scanner inputReader = new Scanner(System.in);
        int x;
        do {
            int[] numbers = new int[20];
            numbers = createNum(numbers);
            printNum(numbers);
            int numLookingFor = RND_GEN.nextInt(10) + 1;
            System.out.println("Number of instances of " + numLookingFor + " is: " + findNumInstancesInArray(numbers, numLookingFor));
            System.out.print("Restart Program?, Enter 1 for YES, 2 for NO: ");
            x = inputReader.nextInt();
        } while (x == 1);
    }

    public static void main(String[] args) {
        Main go = new Main();
        go.run();
    }
}