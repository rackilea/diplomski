public static void displayAll(List<double[]> allNumbers) {
    int maximum = 0;
    for (double[] numbers : allNumbers) {
        for (double number : numbers) {
            maximum = Math.max(maximum, number);
        }
    }
    System.out.println("The greatest ever entered number is " + maximum);
}