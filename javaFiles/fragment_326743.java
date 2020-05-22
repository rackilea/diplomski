private static double roundForI(double toRound, double[] numbers) {
    int minIndex = 0;
    double minDiff = Double.MAX_VALUE;
    double diff;
    for (int i=0; i<numbers.length; ++i) {
        diff = Math.abs(numbers[i]-toRound);
        if (diff < minDiff) {
            minDiff = diff;
            minIndex = i;
        }
    }
    return numbers[minIndex];
}