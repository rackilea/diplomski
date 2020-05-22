public static int[][] reorganize(int[][] numbers) {
    int[][] newNumbers = new int[numbers[0].length][numbers.length];
    for (int y = 0; y < numbers.length; y++) {
        for (int r = 0; r < numbers[y].length; r++) {
            newNumbers[r][y] = numbers[y][r];
        }
    }
    return newNumbers;
}