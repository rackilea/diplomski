public static void factorialNumber() {
    int factorial = 1;
    boolean valid;
    int number = 0;
    String userInput;

    do {
        System.out.println("Please enter a number: ");
        userInput = sc.nextLine();
        valid = validateUserInput(userInput);
    } while (!valid);

    number = Double.valueOf(userInput).intValue();
    System.out.print("The factorial is: " + number + " ");

    for (int i = 1; i <= number; i++) {
        factorial *= i;
        if ((number - i) > 0) {
            System.out.print("x " + (number - i) + " ");
        }
    }

    System.out.println("= " + factorial);
}

private static boolean validateUserInput(String userInput) {
    if (userInput == null) {
        System.out.println("You should enter a number!");
        return false;
    }

    Double userInputNumber;
    try {
        userInputNumber = Double.valueOf(userInput);
    } catch (Exception e) {
        System.out.println("Please enter a valid number value.");
        return false;
    }

    if (userInputNumber <= 0) {
        System.out.println("ERROR Please enter a positive number");
        return false;
    } else if (userInputNumber - userInputNumber.intValue() > 0) {
        System.out.println("ERROR You entered a fractional number!");
        return false;
    }

    return true;
}