public static void printBoard(String array[][]) {
    for (int row = 0; row < 8; row++) {
        for (int col = 0; col < 8; col++) {
            System.out.print(array[row][col]);
        }
        System.out.println();
    }
}