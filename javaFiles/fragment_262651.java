import java.util.*;
public class ListTranspose {
    public static void main(String[] args) {
        Object[][] data = {
            { "Title", "Data1", "Data2", "Data3" },
            { "A", 2, 3, 4 },
            { "B", 3, 5, 7 },
        };
        List<List<Object>> table = new ArrayList<List<Object>>();
        for (Object[] row : data) {
            table.add(Arrays.asList(row));
        }
        System.out.println(table); //  [[Title, Data1, Data2, Data3],
                                   //   [A, 2, 3, 4],
                                   //   [B, 3, 5, 7]]"
        table = transpose(table);
        System.out.println(table); //  [[Title, A, B],
                                   //   [Data1, 2, 3],
                                   //   [Data2, 3, 5],
                                   //   [Data3, 4, 7]]
    }
    static <T> List<List<T>> transpose(List<List<T>> table) {
        List<List<T>> ret = new ArrayList<List<T>>();
        final int N = table.get(0).size();
        for (int i = 0; i < N; i++) {
            List<T> col = new ArrayList<T>();
            for (List<T> row : table) {
                col.add(row.get(i));
            }
            ret.add(col);
        }
        return ret;
    }
}