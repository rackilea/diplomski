public static int[][] inner (int[][] a) {
    int rowL = a.length - 1;
    int colL = a[1].length -1;
    int[][] ret = new int[rowL - 1][colL - 1];

    for (int row = 1; row < rowL; row++) {
        for (int col = 1; col < colL ; col++) {
            ret[row - 1][col - 1] = a[row][col];
        }
    }

    return ret;
}