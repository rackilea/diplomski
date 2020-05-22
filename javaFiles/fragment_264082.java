import java.util.Scanner;

public class PositiveNegative {
    public static void main(String[] args) {
        int numbers = 0, plus = 0, minus = 0;
        double total = 0;
        do{
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter an integer (0 to quit): ");
            numbers = Integer.valueOf(scan.nextLine());
            total += numbers;
            if (numbers > 0)
                plus++;
            if (numbers < 0)
                minus++;
        }
        while (numbers != 0);
        System.out.println("The number of positives is: " + plus);
        System.out.println("The number of negatives is: " + minus);
        System.out.println("The number of total is: " + total);
    }
}