public static double getBalance(String fileName) {
    double balance = 0.0;
    Scanner scanner = null;
    try {
        scanner = new Scanner(new File(fileName));
        while (scanner.hasNextDouble()) {
            balance += scanner.nextDouble();
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    } finally {
        if (scanner != null) {
            scanner.close();
        }
    }
    return balance;
}