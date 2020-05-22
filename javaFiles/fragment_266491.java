private static final Scanner sc = new Scanner(System.in);

public static void main(String[] args) {
    int dimension;
    System.out.println("Enter the dimension of a squared matrix :");
    dimension = sc.nextInt();
    final int col = dimension;
    final int row = dimension;
    int[][] matrix = fillMatrix(row, col);
    displayMatrix(matrix);
}

/**
 * Prints the given matrix to console
 *
 * @param matrix to be printed
 */
private static void displayMatrix(int[][] matrix) {
    System.out.println("You have entered the following matrix");
    for (int row = 0; row < matrix.length; row++) {
        for (int column = 0; column < matrix[row].length; column++) {
            System.out.print(matrix[row][column] + " ");
        }
        System.out.println();
    }
}

/**
 * Uses users input to fill create a matrix with the given dimensions
 *
 * @param row matrix row dimension
 * @param col matrix column dimension
 *
 * @return a filled matrix
 */
private static int[][] fillMatrix(final int row, final int col) {
    System.out.println("Enter elements in the matrix:" + row * col);
    int[][] matrix = new int[col][row];
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            int tmpNumber = 0;
            while(tmpNumber<15 || tmpNumber >60){
                System.out.println(String.format("Enter value for row %s, column %s between 15 and 60", i, j));
                tmpNumber = sc.nextInt();
            }
            matrix[i][j] = tmpNumber;
        }
    }
    return matrix;
}