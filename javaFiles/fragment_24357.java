import java.util.Arrays;

public class ArrayRotator {
    public static void main(String[] args) {
        int[][] a = { { 1, 2, 3, 4 }, { 4, 5, 6, 5 }, { 7, 8, 9, 7 } };

        // uses rotate method to assign new value to array
        a = rotate(a);

    }

    public static int[][] rotate(int[][] arr) {
        // return if supplied array is empty
        if (arr.length == 0) {
            return new int[0][0];
        }

        // create new array with swapped length for rows and columns
        int origRows = arr.length;
        int origCols = arr[0].length;
        int[][] rotatedArr = new int[origCols][origRows];

        for (int i = 0; i < origRows; i++) {
            for (int j = 0; j < origCols; j++) {
                // Rotate array 90 degrees clockwise:
                // new row <- original column
                // new column <- original row, reversed
                rotatedArr[j][i] = arr[origRows - 1 - i][j];
            }
        }

        return rotatedArr;
    }
}