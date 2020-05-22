public static void getRows(char array[][], int counts[][]) {
    for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array[0].length; j++) {
            if (array[i][j] == 'X') {
                counts[i][0]++;
            }
        }
    }
    for (int i = 0; i < array.length; i++) {
        System.out.println("Row " + i + " has " + counts[i][0] + " X");
    }
}