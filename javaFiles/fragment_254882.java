import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test{

    public static int matrix[][];

    public static void main(String[] args) {
        borderLayout(5, 5);
        print();
    }

    public static void borderLayout(int rows, int columns) {
        //create a list (1,3,5, ...) with size = columns - 1
        List<Integer> list = IntStream.iterate(1, i -> i + 2)
                .limit(columns - 1).boxed()
                .collect(Collectors.toList());
        matrix = new int[rows][columns];
        int square = Math.min(rows, columns);
        for (int i = 0; i < square; i++) {
            int temp = (i + 1) * (i + 1);
            for (int j = 0; j < square; j++) {
                if (j == 0) {
                    matrix[i][j] = temp;
                } else {
                    matrix[i][j] = matrix[i][j - 1] + list.get(j - 1);
                }
            }
            if (i < columns - 1) {
                list.set(i, -1);
            }
        }
        if (rows > columns) {
            int counter = (int) Math.pow(Math.min(rows, columns), 2);
            int sqrt = (int) Math.sqrt(counter);
            for (int i = sqrt; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = ++counter;
                }
            }
        } else if (rows < columns) {
            int counter = (int) Math.pow(Math.min(rows, columns), 2);
            int sqrt = (int) Math.sqrt(counter);
            for (int i = sqrt; i < columns; i++) {
                for (int j = 0; j < rows; j++) {
                    matrix[j][i] = ++counter;
                }
            }
        }
    }

    private static void print() {
        for (int[] row : matrix) {
            for (int i : row) {
                System.out.printf("%4d ", i);
            }
            System.out.println();
        }
    }
}