public static void testScanDouble() {
    Scanner sin = new Scanner(System.in);
    System.out.println("Enter a double: ");
    while (!sin.hasNextDouble()) {
        System.out.println("Invalid double, shoot again:");
        sin.nextLine();
    }
    double d = sin.nextDouble();
    System.out.println("Read double value: "+d);
    sin.close();
}