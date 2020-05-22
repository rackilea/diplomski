import java.util.Arrays;

public class RotateMatrix {

    public static void main(String[] args) {
        int original[][] = { { 0, 1, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        printArray(original);
        System.out.println("After 90 Degree");
        printArray(rotate(original, 90));
        System.out.println("After 180 Degree");
        printArray(rotate(original, 180));
        System.out.println("After 270 Degree");
        printArray(rotate(original, 270));
        System.out.println("After 360 Degree");
        printArray(rotate(original, 360));
    }

    private static int[][] rotate(int[][] original, int angle) {

        int[][] output = original;
        int times = 4 - angle/90;

        for(int i=0; i<times; i++){
            output = rotate(output);
        }

        return output;
    }

    private static int[][] rotate(int[][] original) {

        int n = original.length;
        int m = original[0].length;
        int[][] output = new int[m][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                output[j][n - 1 - i] = original[i][j];
        return output;
    }

    private static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

}