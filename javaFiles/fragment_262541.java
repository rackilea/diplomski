double number1 = 0;
boolean success;
do {
    success = true;
    try {
        System.out.print("First number: ");
        number1 = input.nextDouble();
    } catch (InputMismatchException e) {
        System.out.print("This is not a number. ");
        success = false;
    }
    input.nextLine();
} while (!success);