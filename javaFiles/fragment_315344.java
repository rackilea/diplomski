import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatePay {

    private static void doStuff() {
        Scanner reader = new Scanner(System.in);

        String Name = " ";
        int hours;
        double payRate;
        char F;
        char P;
        char T;

        String input = " ";
        char repeat = input.charAt(0);

        double grossPay;
        int attempt = 0;

        System.out.print("What is your name? ");
        Name = reader.nextLine();
        System.out.print("How many hours did you work? ");
        hours = reader.nextInt();
        while (hours < 0 || hours > 280)
        {
            System.out.println("That's not possible, try again!");
            hours = reader.nextInt();
            attempt++;
            if(attempt >= 2) {
                System.out.println("You are Fired!");
                return ; }

        }
        System.out.print("What is your pay rate? ");
        payRate = reader.nextDouble();
        System.out.print("What type of employee are you? ");
        F = reader.next().charAt(0);


        grossPay = hours * payRate;
        DecimalFormat decFor = new DecimalFormat("0.00");




        switch (F)
        {
            case 'F' :
            case 'f' :
                System.out.println("Hi " + Name + ", you made $" + decFor.format(grossPay) + " this week"+" as a full-time employee");
                if (hours < 0)
                {
                    System.out.println(" That's not possible ");
                }
                else if (hours > 280)
                {
                    System.out.print(" That's not possible ");
                }
                else if (grossPay >= 100)
                {
                    System.out.print(" You must be a Java programmer!");
                }
                else
                {
                    System.out.print(" this week");
                }

                break;
            case 'P' :
            case'p' :
                System.out.println("Hi " + Name + ", you made $" + decFor.format(grossPay) + " this week"+" as a part- time employee");
                if (hours < 0)
                {
                    System.out.println(" That's not possible ");
                }
                else if (hours > 280)
                {
                    System.out.print(" That's not possible ");
                }
                else if (grossPay >= 100)
                {
                    System.out.print(" You must be a Java programmer!");
                }
                else
                {
                    System.out.print(" this week");
                }

                break;
            case 'T' :
            case 't' :
                System.out.println("Hi " + Name + ", you made $" + decFor.format(grossPay) + " this week"+" as a temporary employee");
                if (hours < 0)
                {
                    System.out.println(" That's not possible ");
                }
                else if (hours > 280)
                {
                    System.out.print(" That's not possible ");
                }
                else if (grossPay >= 100)
                {
                    System.out.print(" You must be a Java programmer!");
                }
                else
                {
                    System.out.print(" this week");
                }

                break;
            default:
                System.out.println(" unknown employee type");



                if (hours < 0)
                {
                    System.out.println(" That's not possible ");
                }
                else if (hours > 280)
                {
                    System.out.print(" That's not possible ");
                }
                else if (grossPay >= 100)
                {
                    System.out.print(" You must be a Java programmer!");
                }
                else
                {
                    System.out.print(" this week");
                }


        }
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        do {
            //Call your bussines logic.
            doStuff();

            System.out.println("Do you want to run this program again? (Yes or No)");
        }
        while(reader.nextLine().toLowerCase().equals("yes"));
    } }