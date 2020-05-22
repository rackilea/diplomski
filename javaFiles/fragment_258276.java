import java.util.ArrayList;
import java.util.List;

public class Matrix<T> {
    private final int nrow;
    private final int ncol;

    private Matrix(int nrow, int ncol) {
        this.nrow = nrow;
        this.ncol = ncol;
    }

    public static <T> Matrix<T> fromArrays(List<T[]> data) {
        return new Matrix<T>(data.size(), data.get(0).length);
    }

    public static <T> Matrix<T> fromLists(List<? extends List<T>> data) {
        return new Matrix<T>(data.size(), data.get(0).size());
    }
}