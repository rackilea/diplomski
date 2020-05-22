public static double movingaverage(int windowLength) {
    double sum = 0;
    for (int i = Math.max(0, Pressure.length-windowLength); i < Pressure.length; i++){
        sum += Pressure[i];
    }
    double average = sum / windowLength;

    return average;
}