public static long sumSequentially(int [][] matrix) {
    long total = 0;

    for (int i = 0; i < matrix.length; i++) {
        long[matrix[i].length] matrixi = matrix[i];
        for (int j = 0; j < matrixi.length; j++) {
            total += matrixi[j];
        }
    }

    return total;
}