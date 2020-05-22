Scanner user_input = new Scanner(System.in);

// This will be used to track if the vending maching is finished or not
boolean isFinished = false;

// Use a while loop, which causes the program to repeat until the variable 
// isFinished is true (see below)
while(isFinished == false) {

    int potatoChips = 0;
    int cookies = 3;
    int candies = 4;
    int quarters;
    int dimes;
    int nickels;

    System.out.println("Select the number for the item you would like");
    System.out.println("For Potato Chips, Enter 1");
    System.out.println("For Cookies, Enter 2");
    System.out.println("For Candies, Enter 3");
    int itemSelection = user_input.nextInt();

    if (itemSelection == 1) {

        if (potatoChips > 0) {
            potatoChips = potatoChips - 1;
            System.out.println("You chose potato chips.");
            System.out.println("That will be $1.25");
            System.out.println("How many quarters do you have?");
            quarters = user_input.nextInt();
            System.out.println("How many dimes do you have?");
            dimes = user_input.nextInt();
            System.out.println("How many nickels do you have?");
            nickels = user_input.nextInt();

            int nickelsToPennies = (nickels * 5);
            int dimesToPennies = (dimes * 10);
            int quartersToPennies = (quarters * 25);

            int pennies = (nickelsToPennies + dimesToPennies + quartersToPennies);

            if (pennies < 125) {
                System.out.println("You have not entered enough money. Have a great day.");
            }
            else if (pennies == 125 ) {
                System.out.println("Here is your snack. Have a great day");
            }
            else {
                double changeInPennies = (pennies - 125);
                double change = (changeInPennies / 100);
                System.out.println("Your change is $" + change + ". Have a great day.");
            }

            // This causes the machine loop to end
            isFinished = true;
        } 

        else {
            System.out.println("This item is out of stock. Please select another item.");
        }
    }

    if (itemSelection == 2) {

        if (cookies > 0) {
            cookies = cookies - 1;
            System.out.println("You chose a cookie.");
            System.out.println("That will be $0.85");
            System.out.println("How many quarters do you have?");
            quarters = user_input.nextInt();
            System.out.println("How many dimes do you have?");
            dimes = user_input.nextInt();
            System.out.println("How many nickels do you have?");
            nickels = user_input.nextInt();

            int nickelsToPennies = (nickels * 5);
            int dimesToPennies = (dimes * 10);
            int quartersToPennies = (quarters * 25);

            int pennies = (nickelsToPennies + dimesToPennies + quartersToPennies);

            if (pennies < 85) {
                System.out.println("You have not entered enough money. Have a great day.");
            }
            else if (pennies == 85 ) {
                System.out.println("Here is your snack. Have a great day");
            }
            else {
                double changeInPennies = (pennies - 85);
                double change = (changeInPennies / 100);
                System.out.println("Your change is $" + change + ". Have a great day.");
            }

            // This causes the machine loop to end
            isFinished = true;
        } 

        else {
            System.out.println("This item is out of stock. Please select another item.");
        }
    }

    if (itemSelection == 3) {

        if (candies > 0) {
            candies = candies - 1;
            System.out.println("You chose a candy.");
            System.out.println("That will be $0.95");
            System.out.println("How many quarters do you have?");
            quarters = user_input.nextInt();
            System.out.println("How many dimes do you have?");
            dimes = user_input.nextInt();
            System.out.println("How many nickels do you have?");
            nickels = user_input.nextInt();

            int nickelsToPennies = (nickels * 5);
            int dimesToPennies = (dimes * 10);
            int quartersToPennies = (quarters * 25);

            int pennies = (nickelsToPennies + dimesToPennies + quartersToPennies);

            if (pennies < 95) {
                System.out.println("You have not entered enough money. Have a great day.");
            }
            else if (pennies == 95 ) {
                System.out.println("Here is your snack. Have a great day");
            }
            else {
                double changeInPennies = (pennies - 95);
                double change = (changeInPennies / 100);
                System.out.println("Your change is $" + change + ". Have a great day.");
            }

            // This causes the machine loop to end
            isFinished = true;
        } 

        else {
            System.out.println("This item is out of stock. Please select another item.");
        }
    }

    else {
        System.out.println("This is not an item. Please select another item.");
    }
}