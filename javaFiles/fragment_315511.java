if (numberOne > 0) {
    System.out.println("Your original number is " + numberOne);
}
else if (numberOne < 0) {
    System.out.println("Your number was converted to " + (-1 * numberOne) + " because it was negative.");
}
else {
    // Report the error
    System.out.println("***ERROR*** The input is not a number.");
    // Terminate the error
    System.exit(1);
}