private static double getMaxValue(double[] a) {
    int maxIndex = 0; // <-- start with the first
    for (int i = 1; i < a.length; i++) { // <-- start with the second
        if (a[i] > a[maxIndex]) {
            maxIndex = i;
        }
    }
    return a[maxIndex]; // <-- return the max value.
}