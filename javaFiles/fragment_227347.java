import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count = 3;
        int[] numbers = new int[count];
        System.out.println("Enter 3 integers");
        Scanner numScanner = new Scanner(scanner.nextLine());
        int currentIndex = 0;
        while (currentIndex < count) {
            if (numScanner.hasNextInt()) {
                numbers[currentIndex] = numScanner.nextInt();
            } else {
                System.out.println("You didn't provide enough numbers");
                break;
            }
            currentIndex++;
        }
        numScanner.close();
        scanner.close();
    }
}