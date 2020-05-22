void matrixReverse(int[][] data) {
    int rowWidth = data.length;
    int[][] reversedData = new int[rowWidth][];
    for (int row = rowWidth - 1; row >= 0; row--) {
        int colWidth = data[row].length;
        int reverseRow = rowWidth - 1 - row;
        reversedData[reverseRow] = new int[colWidth];
        for (int col = colWidth - 1; col >= 0; col--) {
            int reverseCol = colWidth - 1 - col;
            reversedData[reverseRow][reverseCol] = data[row][col];
        }
    }
    for (int row = 0; row < rowWidth; row++) {
        int colWidth = reversedData[row].length;
        for (int col = 0; col < colWidth; col++) {
            System.out.println(reversedData[row][col]);
        }
        System.out.println();
    }
}