public double getMedian(double[] numberList) {
    int middle = numberList.length / 2;
    if (numberList.length % 2 == 0) {
        double total = numberList[middle - 1] + numberList[middle]
        return total / 2;
    } else {
        return numberList[middle];
    }
}