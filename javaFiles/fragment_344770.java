public static void findGroups(Integer[][] array, int column, int row, int height, int length) {
    for (int i = 0; i < height; i++) {
        for (int j = 0; j < length; j++) {
            if (array[i][j] == 1) {
                fill(array, i,j, height, length);
                counter++;
            }
        }
    }
    for (int i = 0; i < height; i++) {
        for (int j = 0; j < length; j++) {
            if (array[i][j] > 1) {
                array[i][j]--;
            }
        }
    }
}