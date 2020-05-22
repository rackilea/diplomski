public static double sum2d(double[][] theSum) {
    double total2 = 0;
    for (int row = 0; row < theSum.length; row++) {
        for (int col = 0; col < theSum[row].length; col++){
            total2 = total2 + theSum[row][col];
        }
    }
    return total2;
}