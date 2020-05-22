public double getRange(double[] numberList) {
    double initMin = numberList[0];
    double initMax = numberList[0];
    for (int i = 1; i <= numberList.length; i++) {
        if (numberList[i] < initMin) initMin = numberList[i];
        if (numberList[i] > initMax) initMax = numberList[i];
    }
    return initMax - initMin;
}