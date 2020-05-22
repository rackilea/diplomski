private static void calcEstimates() {
    int sampleSize;
    double sum;
    double mean;
    double sumSqrDev;
    double stdDev;

    System.out.println("size   mean      stdDev");
    System.out.println("------------------------");
    for (int i = 0; i < sampleSizes.length; i++) {

        sum = 0;
        sampleSize = sampleSizes[i];

        // 1. Step: Calculation of the mean
        double[] temps = new double[sampleSize]; // N
        for (int j = 0; j < sampleSize; j++) {
            temps[j] = allTemps[rng.nextInt(numTemps)];
            sum += temps[j];
        }

        mean = sum / sampleSize;

        // 2. Step: Calculation of the standard deviation
        sumSqrDev = 0;
        for (int j = 0; j < sampleSize; j++) {
            sumSqrDev += Math.pow((temps[j] - mean), 2);
        }

        stdDev = Math.sqrt(sumSqrDev / (sampleSize - 1));

        System.out.printf("%5d  %.4f  %.4f\n", sampleSize, mean, stdDev);
    }
}