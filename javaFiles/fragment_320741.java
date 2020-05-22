private static int nonNegativeInt() {
    int value = 0;
    while (true) {
        try {
            if ((value = scanner.nextInt()) >= 0)
                return value;
            System.out.println("Please enter a positive number");
        } catch (InputMismatchException e) {
            System.out.println("That is not a valid value");
            scanner.next();
        }
    }
}