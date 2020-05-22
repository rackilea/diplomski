import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class DtoTableModel<T> extends AbstractTableModel {

    private final ArrayList<T>                    rows;
    private final ArrayList<ColumnProvider<T, ?>> columns;

    protected DtoTableModel() {
        rows = new ArrayList<T>();
        columns = new ArrayList<ColumnProvider<T, ?>>();
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return columns.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return columns.get(columnIndex).getValue(rows.get(rowIndex));
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        final ColumnProvider<T, ?> column = columns.get(columnIndex);
        column.setValue(rows.get(rowIndex), aValue);
        this.fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return columns.get(column).getTitle();
    }

    public void addColumn(ColumnProvider<T, ?> column) {
        this.columns.add(column);
        this.fireTableStructureChanged();
    }

    public void addRow(T row) {
        this.rows.add(row);
        this.fireTableRowsInserted(this.rows.size() - 1, this.rows.size() - 1);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return this.columns.get(columnIndex).getValueClass();
    }

    public static abstract class ColumnProvider<T, V> {
        private       String   title;
        private final Class<V> valueClass;

        protected ColumnProvider(String title, Class<V> valueClass) {
            this.title = title;
            this.valueClass = valueClass;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Class<V> getValueClass() {
            return valueClass;
        }

        public abstract V getValue(T dto);

        public abstract void setValue(T dto, Object value);
    }
}