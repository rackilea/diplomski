import java.util.InputMismatchException;
import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {
        int days, cus, carType, fuel, count = 0;
        double dailyFee = 0, nonTaxTotal = 0, total = 0, fullTotal = 0, fuelcharge = 0, taxes = 0, avrg = 0, Fullcharge = 0;
        boolean checkRunOrQuit = false, chooseTypeVehicle = false, numberOfDAysChosen = false, fuellevel = false;
        Scanner in = new Scanner(System.in);
        while (true) {

            while (!checkRunOrQuit) {
                System.out.print("Press 1 to enter Rental Calculator or else press 0 to quit\n");
                System.out.println("Please only enter 1 or 0. Also, please only enter number(s) not letter(s)");
                try {
                    cus = in.nextInt();
                    switch (cus) {
                        case 0:
                            System.out.print("End of application\n");
                            System.out.println("Count of customers: " + count);
                            System.out.printf("Total fuel charges $ %.2f \n", Fullcharge);
                            System.out.printf("Total taxes collected: $ %.2f \n", taxes);
                            System.out.printf("Total of the Day: $ %.2f \n", fullTotal);
                            System.out.printf("The average bill was: $ %.2f \n", avrg);
                            System.exit(0);
                            break;
                        case 1:
                            checkRunOrQuit = true;
                            break;
                        default:
                            System.out.println("Number must be either 1 or 0");
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("Invalid entry: ");
                    in.next();
                }
            }

            checkRunOrQuit = false;

            while (!chooseTypeVehicle) {

                System.out.print("What vehical would you like to rent?\n");
                System.out.println("Enter 1 for an economy car");
                System.out.println("Enter 2 for a sedan car");
                System.out.println("Enter 3 for an SUV");

                try {
                    carType = in.nextInt();
                    chooseTypeVehicle = true;
                    switch (carType) {
                        case 1:
                            dailyFee = 31.76;
                            count++;
                            break;
                        case 2:
                            dailyFee = 40.32;
                            count++;
                            break;
                        case 3:
                            dailyFee = 47.56;
                            count++;
                            break;
                        default:
                            System.out.print("Number must be 1-3\n");
                            chooseTypeVehicle = false;
                            break;
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("Answer must be a number");
                    in.next();
                }
            }

            chooseTypeVehicle = false;

            while (!fuellevel) {
                try {
                    System.out.print("Is the fuel empty?\n");
                    System.out.println("Please enter 1 for yes.");
                    System.out.println("Please enter 2 for no.");
                    fuel = in.nextInt();
                    if (fuel <= 0 | fuel > 2.1) {
                        System.out.print("Please enter a 1 or 2\n");
                    } else {
                        fuellevel = true;
                        switch (fuel) {
                            case 1:
                                fuelcharge = 40.00;
                                fuelcharge += Fullcharge;
                                break;
                            case 2:
                                fuelcharge = 0.00;
                                break;
                        }
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("Answer must be a number");
                    in.next();
                }
            }

            fuellevel = false;

            while (!numberOfDAysChosen) {
                try {
                    System.out.print("Please enter the number of days rented. (Example; 3) : ");
                    days = in.nextInt();
                    if (days <= 0) {
                        System.out.println("Number of days must be more than zero");
                    } else {
                        nonTaxTotal = (dailyFee * days);
                        nonTaxTotal = (nonTaxTotal + fuelcharge);
                        total = (nonTaxTotal * 1.06);
                        taxes = (total - nonTaxTotal);
                        avrg = (total / count);
                        fullTotal += total;
                        numberOfDAysChosen = true;
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("Answer must be a number");
                    in.next();
                }
            }

            numberOfDAysChosen = false;

            System.out.printf("Rental rate: $%.2f \n", dailyFee);
            System.out.printf("Total fuel charge: $%.2f \n", fuelcharge);
            System.out.printf("Subtotal: $%.2f \n", nonTaxTotal);
            System.out.printf("Taxes: $%.2f \n", taxes);
            System.out.printf("Total: $%.2f \n", fullTotal);

        }
    }

}