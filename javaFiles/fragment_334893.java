import java.util.Scanner; //for Scanner class

public class AverageRainfall {
 public static void main(String[] args) {
    final int NUM_MONTHS = 12; // Months per year
    int years; // Number of years
    double monthRain=0; // Rain for a month
    double totalRain = 0; // Rainfall accumulator
    double average; // Average rainfall

    Scanner keyboard = new Scanner(System.in);

    System.out.print("Enter the number of years: ");
    years = keyboard.nextInt();

    while (years < 1) {
        System.out.print("Invalid. Enter 1 or greater: ");
        years = keyboard.nextInt();

    }


    System.out.println("Enter the rainfall, in inches, for each month. ");
    for (int y = 1; y <= years; y++) {

        for (int m = 1; m <= NUM_MONTHS; m++) {

            System.out.print("Year" + y + "month" + m + ": ");
            monthRain = keyboard.nextDouble();

            while (monthRain < 0) {
                System.out.print("Invalid. Enter 0 or greater: ");
                monthRain = keyboard.nextDouble();
            }
            totalRain += monthRain;
        }   
    }   





    average = totalRain / (years * NUM_MONTHS);

    System.out.println("\nNumber of months: " + (years * NUM_MONTHS));
    System.out.println("Total rainfall: " + totalRain + " inches");
    System.out.println("Average monthly rainfall: " + average
                + " inches");

 }
}