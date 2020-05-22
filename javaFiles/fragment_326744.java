private static double roundForEach(double toRound, double[] numbers) {
    double diff, roundValue = 0, minDiff = Double.MAX_VALUE;
    for (double dob : numbers) {
        if ((diff = Math.abs(dob-toRound)) < minDiff) {
            minDiff = diff;
            roundValue = dob;
        }
    }
    return roundValue;
}