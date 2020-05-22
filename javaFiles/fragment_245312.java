public class FinalSumRowColumn {
    public static void main(String[] args) {

        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println("\nSum Row 1 = " + sumRow(mat, 0));
        System.out.println("\nSum Col 1 = " + sumCol(mat, 0));
        System.out.println("\nSum Row 1 = " + sumRow(mat, 1));
        System.out.println("\nSum Col 1 = " + sumCol(mat, 1));
        System.out.println("\nSum Row 1 = " + sumRow(mat, 2));
        System.out.println("\nSum Col 1 = " + sumCol(mat, 2));
    }

    public static int sumRow(int[][] mat, int row) {
        int total = 0;

        for (int column = 0; column < mat[row].length; column++) {
            total += mat[row][column];
        }
        return total;
    }

    public static int sumCol(int[][] mat, int col) {
        int total = 0;

        for (int row = 0; row < mat[0].length; row++) {
            total += mat[row][col];
        }
        return total;
    }
}