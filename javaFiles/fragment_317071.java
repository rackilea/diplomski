This method is going on the assumption that the passed array is already sorted (i.e. {1,2,3,...}).

public double getMedian(double[] numberList) {
    int factor = numberList.length - 1;
    double[] first = new double[(double) factor / 2];
    double[] last = new double[first.length];
    double[] middleNumbers = new double[1];
    for (int i = 0; i < first.length; i++) {
        first[i] = numbersList[i];
    }
    for (int i = numberList.length; i > last.length; i--) {
        last[i] = numbersList[i];
    }
    for (int i = 0; i <= numberList.length; i++) {
        if (numberList[i] != first[i] || numberList[i] != last[i]) middleNumbers[i] = numberList[i];
    }
    if (numberList.length % 2 == 0) {
        double total = middleNumbers[0] + middleNumbers[1];
        return total / 2;
    } else {
        return middleNumbers[0];
    }
}