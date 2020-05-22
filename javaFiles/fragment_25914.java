public static void testScanDoubleWithException() {
    Scanner sin = new Scanner(System.in);
    System.out.println("Enter a double: ");
    while (true) {
        try {
            double d = sin.nextDouble(); // Throw if not a double
            System.out.println("Read double value: "+d);
            break;
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid double, shoot again:");
            sin.nextLine(); // consume bad input
        }
    }
    sin.close();
}