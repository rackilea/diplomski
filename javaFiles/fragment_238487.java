public double[] max() {
    int maxIndex = 0; // <-- start with the first
    for (int i = 1; i < mdarray.length; i++) { // <-- start with the second
        double maxValue = getMaxValue(mdarray[maxIndex]);
        double curValue = getMaxValue(mdarray[i]);
        if (curValue > maxValue) {
            maxIndex = i; // <-- The current value is greater, update the index.
        }
    }
    return Arrays.copyOf(mdarray[maxIndex], mdarray[maxIndex].length);
}