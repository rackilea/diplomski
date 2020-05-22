public static double averageOfNumbers(double[] x) {
    double sum = 0; // Variable to store the sum
    int count = 0; // Variable to keep the count

    if (x != null) {
        for (int i = 0; i < x.length; i++) {
            double value = x[i];
            if (value >= 0) { // Check if the number is non-negative
                sum += value; // Add the value to the current sum
                count++; // Increment the count by 1
            }
        }

    }
    return (count > 0) ? (sum /count) : 0; // Calculate the average if there were any non-negative numbers

}