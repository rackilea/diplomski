public static void main(String[] args) {
    int n = getMatrixSize();
    int[][] m = makeAndFillMatrix(n);//<<<----Problem 4
    printMatrix(m);
}

public static int getMatrixSize() {
    Scanner S = new Scanner(System.in);

    System.out.println("give me a int to create the matrix");
    int n = S.nextInt();//<<--------------Problem 1
    return n;
}

public static int[][] makeAndFillMatrix(int n) {//<<<---Problem 3
    Random generator = new Random(5);
    int[][] r = new int[n][n];
    int rand = generator.nextInt(10);
    for (int i = 0; i < r.length; i++) {
        for (int j = 0; j < i; j++) {//<<<-----------Problem 2
            r[i][j] = rand;
        }
    }
    return r;
}

public static void printMatrix(int[][] matrix) {
    for (int r = 0; r < matrix.length; r++) {
        for (int c = 0; c < matrix[r].length; c++) {
            System.out.print(matrix[r][c] + " ");
        }
        System.out.println();
    }
}