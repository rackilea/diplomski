import java.util.Scanner;

public class GasCalculator {

    public static void main (String args[])
    {

        double total = 0;       

        Scanner scan = new Scanner(System.in);

        System.out.println("How many miles do you plan to travel?");
        int miles = scan.nextInt();
        System.out.println("So you will drive " + miles +" miles.");

        System.out.println("What is the price of gas?");
        double gas = scan.nextDouble();
        System.out.println("Ok, so gas costs $" + gas +" per gallon.");

        System.out.println("What is the average MPG of your car? Use the nearest whole number.");
        int mpg = scan.nextInt();
        System.out.println("So, you get " + mpg +" miles per gallon.");

        System.out.println("Would you like an oil change? Enter Y or N");
        char oil = scan.next().charAt(0);
        if (Character.toUpperCase(oil) == 'Y'){
            System.out.println("Cost of oil change id 39.99);
            System.out.println("39.99 will be added to your total cost");
            total += 39.99;
        }

        double cost = (miles / mpg * gas);
        total += cost;

        String menu = "Pick a menu option: \n"
                      + "1. Calculate total \n"
                      + "2. exit";

        System.out.println(menu);
        int choice = scan.nextInt();
        if (choice == 1){
            System.out.println("Below is your total cost");
            System.out.println(String.format("Your trip will cost $" + total + "."));
        } else {
            System.exit(0);
        }
    }
}