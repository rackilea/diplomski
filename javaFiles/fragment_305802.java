import java.util.Arrays;

public class Matrix {

    private int[][] array;
    private int[][] array2;// remove this
    private int theRow;// remove this
    private int theCol;// remove this


    public void transpose() {

        int m = array.length;
        int n = array[0].length;

        int[][] transpose = new int [n][m];

        for (int r = 0; r < m; r++)  {
            for (int c = 0; c < n; c++)  {
                transpose[c][r] = array[r][c];                     
            }
        }
        array = transpose;
    }
}