boolean inputOk = false;
while (!inputOk) {
    System.out.print("Define width: ");
    try {
        width = scanner.nextDouble();
        inputOk = true;
    } catch (InputMismatchException e) {
        System.err.println("That's not a number!");
        scanner.nextLine();   // This discards input up to the 
                              // end of line
        // Alternative for Java 1.6 and later
        // scanner.reset();   
    }
}