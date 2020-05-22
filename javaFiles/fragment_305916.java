import java.util.Scanner;

public class BalAfter6Months{

    public static void main(String []args){

        double interest, balance;

        Scanner sc = new Scanner (System.in);
        System.out.print("Enter the monthly saving amount: ");

        balance = sc.nextDouble();

        int count = 1
        while (counter < 7) {
            interest = balance * 0.00417;
            balance += interest
            counter++;
        }

        System.out.print(total);

    }

}