import java.util.HashMap;
import java.util.Map;

public class SparseMatrix<T> {
    final Map<Integer, T>[] maps;
    final int rows, columns;

    public SparseMatrix(int rows, int columns) {
        maps = new Map[rows];
        for (int i = 0; i < rows; i++)
            maps[i] = new HashMap<>();
        this.rows = rows;
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public T get(int r, int c) {
        return maps[r].get(c);
    }

    public void set(int r, int c, T t) {
        maps[r].put(c, t);
    }
}