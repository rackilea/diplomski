public static double[] diamondSolve(double a, double b) {
    double temp = b * b - 4 * a;
    double difference = Math.sqrt(temp); // difference = C - D

    double[] retArray = new double[2];

    // (b + difference) / 2 = (C + D + C - D) / 2 = 2C / 2 = C
    retArray[0] = (b + difference) / 2;

    // B - C = C + D - C  = D
    retArray[1] = b - retArray[0];

    return retArray;
}