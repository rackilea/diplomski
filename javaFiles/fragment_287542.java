Scanner inputScanner = new Scanner(System.in);
try {
    try {
        // 1st operation
    } catch (Exception e) {
        System.err.println("1st operation failed");
    }
    try {
        // 2nd operation
    } catch (Exception e) {
        System.err.println("2nd operation failed");
    }
} finally {
    inputScanner.close();
}