import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.AbstractTableModel;

public class SimpleTableExample {

    public static void main(String[] args) {
        new SimpleTableExample();
    }

    public SimpleTableExample() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                ColumnBasedTableModel model = new ColumnBasedTableModel();
                model.addColumn("Column 1", createColumn(1, 5));
                model.addColumn("Column 2", createColumn(6, 9));
                model.addColumn("Column 3", createColumn(11, 3));
                model.addColumn("Column 4", createColumn(16, 8));
                model.addColumn("Column 5", createColumn(21, 15));
                model.addColumn("Column 6", createColumn(26, 7));


                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(new JTable(model)));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    protected String[] createColumn(int startAt, int count) {

        String[] values = new String[count];
        for (int index = 0; index < count; index++) {
            values[index] = Integer.toString(startAt + index);
        }
        return values;

    }

    public class ColumnBasedTableModel extends AbstractTableModel {

        private Map<String, List<String>> columnData;
        private List<String> columnNames;

        public ColumnBasedTableModel() {
            columnData = new HashMap<>(25);
            columnNames = new ArrayList<>(25);
        }

        public void addColumn(String name, String... data) {
            columnNames.add(name);
            List<String> colData = columnData.get(name);
            if (colData == null) {
                colData = new ArrayList<>(26);
                columnData.put(name, colData);
            }
            colData.addAll(Arrays.asList(data));
        }

        @Override
        public int getRowCount() {
            int rows = 0;
            for (List<String> data : columnData.values()) {
                rows = Math.max(data.size(), rows);
            }
            return rows;
        }

        @Override
        public int getColumnCount() {
            return columnNames.size();
        }

        @Override
        public String getColumnName(int column) {
            return columnNames.get(column);
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Object value = null;
            String name = getColumnName(columnIndex);
            List<String> data = columnData.get(name);
            if (data != null) {

                if (rowIndex < data.size()) {
                    value = data.get(rowIndex);
                }

            }
            return value;
        }

    }

}