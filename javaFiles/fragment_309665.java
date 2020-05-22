private static double skipAndGetDouble(Scanner scanner) {
    while (scanner.hasNext() && !scanner.hasNextDouble()) {
        scanner.next();
    }
    return scanner.hasNextDouble() ? scanner.nextDouble() : Double.NaN;
}