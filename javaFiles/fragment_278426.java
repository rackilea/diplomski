import java.util.Scanner;

public class InterestCalculator {

public static void main(String[] args) {
//      EDIT: you already have a scanner defined below with a more meaningful name so I removed this one
//      Scanner scannerObject = new Scanner(System.in);

        Scanner input = new Scanner(System.in);

        //EDIT: defining userResponse outside the loop so we can use it everywhere inside
        String userResponse = null;

        do {
            //EDIT: moved the variables inside the loop so that they are reset each time we start over.
            //EDIT: initialize your variable to a value that is invalid so that you can tell if it has been set or not.
            int quartersDisplayed = -1;
            //EDIT: gave your variables more meaningful names that conform to java standards
            double startingBalance = -1, interestRate = -1;

            //EDIT: you don't need a second Scanner, just use the one you already have.
//          Scanner keyboard = new Scanner(System.in);

            do{
                System.out.println("Enter the numbers of quarters you wish to display that is greater than zero and less or equal to 10: ");
                userResponse  = input.next();
                try{
                    quartersDisplayed = Integer.parseInt(userResponse);
                }catch(NumberFormatException e){
                    //nothing to do here, error message handled below.
                }
                if(quartersDisplayed <= 0 || quartersDisplayed > 10){
                    System.out.println("Sorry, that value is not valid.");
                }else{
                    break;
                }
            }while(true);


            do{
                System.out.println("Enter the starting balance (must be greater than zero): ");
                userResponse  = input.next();
                try{
                    startingBalance = Double.parseDouble(userResponse);
                }catch(NumberFormatException e){
                    //nothing to do here, error message handled below.
                }
                if(startingBalance <= 0){
                    System.out.println("Sorry, that value is not valid.");
                }else{
                    break;
                }
            }while(true);


            do{
                System.out.println("Enter the interest rate (greater than zero less than twenty percent): ");
                userResponse  = input.next();
                try{
                    interestRate = Double.parseDouble(userResponse);
                }catch(NumberFormatException e){
                    //nothing to do here, error message handled below.
                }
                //Note: I assume twenty percent is represented as 20.0 here
                if(interestRate <= 0 || interestRate > 20){
                    System.out.println("Sorry, that value is not valid.");
                }else{
                    break;
                }
            }while(true);


            System.out.println("You have entered the following amount of quarters: "
                            + quartersDisplayed);
            System.out.println("You also entered the starting balance of: " + startingBalance);
            System.out.println("Finally, you entered the following of interest rate: "
                            + interestRate);
            System.out.println("If this information is not correct, please exit the program and enter the correct information.");

            double quarterlyEndingBalance = startingBalance + (startingBalance * interestRate / 100 * .25);
            System.out.println("Your ending balance for your quarters is "
                    + quarterlyEndingBalance);
            System.out.println("Do you want to continue?");
            //EDIT: modified your variable name to be more meaningful since the user's response doesn't have to "yes" necessarily
            userResponse = input.next();
//          EDIT: modified the logic here to compare with "yes" or "y" case insensitively.
//          if (userResponse.equals(userResponse))
            if("y".equalsIgnoreCase(userResponse) || "yes".equalsIgnoreCase(userResponse))
                continue;
            else
                break;

        } while (true);