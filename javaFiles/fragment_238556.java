import java.util.ArrayList;
import java.util.List;

public class Grafs {
    private List<Row_> rows = new ArrayList<Row_>();

    public List<Row_> getRows() {
        return rows;
    }
    public void setRows(List<Row_> rows) {
        this.rows = rows;
    }
    @Override
    public String toString() {
        return "Grafs [rows=" + rows + "]";
    }
}