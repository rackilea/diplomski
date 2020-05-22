public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    boolean yesno = true;
    while (yens == true) {
        System.out.println("Enter a 5 digit number...");
        try {
            int number = scan.nextInt();
            int length = String.valueOf(number).length();

            if (length == 5) {
                String digits = String.valueOf(number);
                char number1 = digits.charAt(0);
                char number2 = digits.charAt(1);
                char number3 = digits.charAt(2);
                char number4 = digits.charAt(3);
                char number5 = digits.charAt(4);

                if (number1 % 2 != 0 && number2 % 2 != 0 && number3 % 2 != 0 && number4 % 2 != 0 && number5 % 2 != 0) {
                    System.out.println("All of the numbers are odd...");
                } else {
                    System.out.println("Not all of the numbers are odd...");
                }
            } else {
                System.out.println("You did not enter a 5 digit number! Try again...");
                continue;
            }
        } catch (Exception e) {
            System.out.println("That was not a number! Try again...");
            //A newline might still be stuck in the scanner, so clear it
            scan.nextLine();
            continue;
        }
        try {
            System.out.println("Would you like to enter another number? (Y/N)");

            char letter = scan.next().charAt(0);
            if (letter == 'Y' || letter == 'y') {
                continue;
            } else if (letter == 'N' || letter == 'n') {
                yesno = false;
            } else {
                System.out.println("I will take that as a no!");
                yesno = false;
            }
        } catch (Exception e) {
            System.out.println("You did not enter a letter...");
            scan.nextLine();
        }
    }
    System.out.println("Goodbye!");
}