public class Main {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int[][] diagonalArray = createDiagonalArray(array, 3, 4);
        print2DArray(diagonalArray);
    }

    private static int[][] createDiagonalArray(int[] array, int p, int q) {

        int[][] input = new int[p][q];
        for (int j = 0; j < p; j++) {
            for (int i = 0; i < q; i++) {
                input[j][i] = array[j * q + i];
            }
        }

        final int numRows = input.length;
        final int numColumns = input[0].length;
        int[][] result = new int[numRows][numColumns];

        int rowIndex = 0;
        int columnIndex = 0;
        int currentRow = 0;
        int currentColumn = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                result[currentRow][currentColumn] = input[i][j];
                if (currentRow == numRows - 1) {
                    if (numRows < numColumns && columnIndex < numColumns - 1) {
                        currentRow = 0;
                        currentColumn = ++columnIndex;
                    } else {
                        currentRow = ++rowIndex;
                        currentColumn = numColumns - 1;
                    }
                } else if (currentColumn == 0) {
                    if (columnIndex < numColumns - 1) {
                        currentRow = rowIndex;
                        currentColumn = ++columnIndex;
                    } else {
                        currentColumn = columnIndex;
                        currentRow = ++rowIndex;
                    }
                } else {
                    currentRow++;
                    currentColumn--;
                }

            }
        }
        return result;
    }

    private static void print2DArray(int[][] diagonalArray) {
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 4; i++) {
                System.out.print(diagonalArray[j][i] + " ");
            }
            System.out.println();
        }
    }
}