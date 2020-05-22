int[][] array2d = new int[3][5]
for (int i = 0; i < array2d.length; i++) {
    for (int j = 0; j < array2d[0].length; j++) {
        array2d[i][j] = (i * array2d[0].length) + j + 1;
    }
}