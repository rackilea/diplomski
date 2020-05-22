import java.util.Scanner;

public class HW04P05 {

    private static final int PACKAGE_1 = 1;
    private static final int PACKAGE_2 = 2;
    private static final int PACKAGE_3 = 3;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int plan = getPlan(input);
        int month = getMonth(input);
        int hours = getHours(input, month);
        calculateSavings(plan, hours);
    }

    private static int getPlan(Scanner input) {
        // packages menu
        System.out.println();
        System.out.println("[1] Package 1: $15.95 a month for up to 10 hours of service. Additional hours are $2.00 per hour.");
        System.out.println("[2] Package 2: $20.95 a month for up to 20 hours of service. Additional hours are $1.00 per hour.");
        System.out.println("[3] Package 3: $30.99 per month unlimited access.");
        System.out.println();
        System.out.print("Enter [1 - 3] for select your package: ");

        // get input
        int choice = input.nextInt();

        // input validation
        System.out.println(" ");
        if (choice < 0) {
            exitProgram("The menu choice cannot be negative, must be a value [1 - 3]");
        } else if (choice == 0) {
            exitProgram("The menu choice cannot be zero, must be a value [1 - 3]");
        } else if (choice > 3) {
            exitProgram("The menu choice must be a value [1 - 3]");
        }
        return choice;
    }

    private static int getMonth(Scanner input) {
        // month menu
        System.out.println("[1] January   [4] April  [7] July       [10] October");
        System.out.println("[2] February  [5] May    [8] August     [11] November");
        System.out.println("[3] March     [6] June   [9] September  [12] December");
        System.out.println("");
        System.out.print("Enter [1 - 12] for select billed month: ");

        // get input
        int month = input.nextInt();

        // input validation
        if (month < 0) {
            exitProgram("The month cannot be negative, must be a value [1 - 12]");
        } else if (month == 0) {
            exitProgram("The month cannot be zero, must be a value [1 - 12]");
        } else if (month > 12) {
            exitProgram("The month must be a value [1 - 12]");
        }
        return month;
    }

    private static int getHours(Scanner input, int month) {
        // hours menu
        System.out.println(" ");
        System.out.print("Enter the number of hours the plan package was used: ");

        // get input
        int hours = input.nextInt();

        // input validation
        if (hours < 0) {
            exitProgram("ERROR: The number of hours cannot be negative.");
        }
        if ((month ==  1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && hours > 744) {
            exitProgram("ERROR: The number of hours cannot be higher than 744 on the month selected.");
        }
        if ((month ==  4 || month == 6 || month == 9 || month == 11) && hours > 720) {
            exitProgram("ERROR: The number of hours cannot be higher than 720 on the month selected.");
        }
        if (month == 2 && hours > 672) {
            exitProgram("ERROR: The number of hours cannot be higher than 672 on the month selected.");
        }

        return hours;
    }

    private static void calculateSavings(int plan, int hours) {
        double pricePlan1 = calculatePricePlan1(hours);
        double pricePlan2 = calculatePricePlan2(hours);
        double pricePlan3 = 30.99;

        switch(plan) {
            case PACKAGE_1:
                System.out.println(String.format("The cost of your bill is: $%.2f", pricePlan1));
                if (pricePlan1 > pricePlan2) {
                    System.out.println(String.format("On package 2 you could have saved $%.2f", pricePlan1 - pricePlan2));
                }
                if (pricePlan1 > pricePlan3) {
                    System.out.println(String.format("On package 3 you could have saved $%.2f", pricePlan1 - pricePlan3));
                }
                break;

            case PACKAGE_2:
                System.out.println(String.format("The cost of your bill is: $%.2f", pricePlan2));
                if (pricePlan2 > pricePlan3) {
                    System.out.println(String.format("On package 3 you could have saved $%.2f", pricePlan2 - pricePlan3));
                }
                break;

            case PACKAGE_3:
                System.out.println(String.format("The cost of your bill is: $%.2f", pricePlan3));
                break;
        }
    }

    private static double calculatePricePlan1(int hours) {
        if (hours <= 10) {
            return 15.95;
        }

        return 15.95 + ((hours - 10) * 2);
    }


    private static double calculatePricePlan2(int hours) {
        if (hours <= 20) {
            return 20.95;
        }

        return 20.95 + (hours - 20);
    }

    private static void exitProgram(String reason) {
        System.out.println(reason);
        System.out.println("The program will now exit.");
        System.exit(1);
    }
}