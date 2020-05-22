public static double calculateMode(final double[] numberList) {
    double[] cnts = new double[numberList.length];
    double mode = 0, max = 0;

    for (int i = 0; i < numberList.length; i++) {
        /* Update Count Counter */
        cnts[numberList[i]]++;
        /* Check */
        if (max < cnts[numberList[i]]) {
            /* Update Max */
            max = cnts[numberList[i]];
            /* Update Mode */
            mode = numberList[i];
        }
    }
    /* Return Result */
    return mode;
}