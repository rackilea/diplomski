public static double modeCalc(double[] numRead, int num) {
    double maxValue = numRead[0];
    double lastValue = maxValue;
    int count = 1;
    int maxCount = 1;
    for (int i = 1; i < num; i++) {
        if (numRead[i] == lastValue) {
            count++;
        } else {
            count = 1;
            lastValue = numRead[i];
        }
        if (count > maxCount) {
            maxCount = count;
            maxValue = lastValue;
        }
    }
    return maxValue;
}