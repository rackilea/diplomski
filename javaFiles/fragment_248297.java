import java.util.ArrayList;
import java.util.List;

public class Array {
    List<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();

    List<ArrayList<Integer>> fillMatrix() {
        for (int row = 0; row < 5; row++) {
            matrix.add(new ArrayList<Integer>());
            for (int column = 0; column < 4; column++) {
                matrix.get(row).add(column,  row * column);
            }
        }
        return matrix;
    }
}