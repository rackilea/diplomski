import java.util.StringJoiner;

public class Test {

    public static void main(String[] args) {
        int[][] easyGrid = {
            {2, 3, 5, 9, 7, 1, 8, 4, 6},
            {4, 7, 1, 2, 8, 6, 9, 3, 5},
            {8, 9, 6, 4, 3, 5, 2, 7, 1},
            {1, 6, 8, 7, 4, 9, 5, 2, 3},
            {7, 4, 9, 5, 2, 3, 1, 6, 8},
            {3, 5, 2, 1, 6, 8, 4, 9, 7},
            {6, 2, 4, 8, 1, 7, 3, 5, 9},
            {9, 1, 3, 6, 5, 2, 7, 8, 4},
            {5, 8, 7, 3, 9, 4, 6, 1, 2}};
        for (int[] row : easyGrid) {
            StringJoiner sj = new StringJoiner(" | ");
            for (int col : row) {
                sj.add(String.format("%02d", col));
            }
            System.out.println(sj.toString());
        }
    }

}