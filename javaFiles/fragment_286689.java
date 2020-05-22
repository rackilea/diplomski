import java.util.Scanner;

public class Main {

    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int[][] matrix = create(1, (int) Math.pow(2, n));
        print(matrix);
    }

    private static int[][] create(final int startValue, final int size) {
        if (size == 1) {
            return new int[][]{{startValue}};
        } else {
            final int half = size / 2;
            final int step = half * half;
            return combine(create(startValue, half), create(startValue + step, half),
                    create(startValue + 2 * step, half), create(startValue + 3 * step, half));
        }
    }

    private static int[][] combine(final int[][] m1, final int[][] m2, final int[][] m3, final int[][] m4) {
        final int initialSize = m1.length;
        final int sizeOfResult = initialSize * 2;
        final int[][] result = new int[sizeOfResult][sizeOfResult];
        for (int row = 0; row < initialSize; row++) {
            for (int col = 0; col < initialSize; col++) {
                result[row][col] = m1[row][col];
                result[row][col + initialSize] = m2[row][col];
                result[row + initialSize][col] = m3[row][col];
                result[row + initialSize][col + initialSize] = m4[row][col];
            }
        }
        return result;
    }

    private static void print(final int[][] matrix) {
        for (final int[] row : matrix) {
            for (final int val : row) {
                System.out.printf("%-5d", val);
            }
            System.out.println();
        }
    }
}