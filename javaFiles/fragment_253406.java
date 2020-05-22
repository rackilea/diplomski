import java.util.Scanner;

public class n01092281 {
    //for loop that computes a sum of the series
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your nth term for the series.");
        double userInput = input.nextInt();
        double sum = 0.0;
        for (double i = 1; i <= userInput - 2; i += 2) {
            sum += (i / (i + 2));
        }
        System.out.println(sum);
    }
}