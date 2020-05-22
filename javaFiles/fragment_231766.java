public static double calcMean(int scores[], double count) {
    double average = 0;
    for(int i = 0; i < inputArr.length; i++) {
    //                 ^------------------------------ should be `scores`
        average = average + scores[i] / count;
    }
    return average;
}