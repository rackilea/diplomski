public double getMean(double[] numberList) {
    double total;
    for (double d: numberList) {
        total += d;
    }
    return total / (numberList.length);
}