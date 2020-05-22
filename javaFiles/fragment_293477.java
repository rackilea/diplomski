import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class TableSparse extends JPanel
{
    public TableSparse(int row, int column)
    {
        setLayout( new BorderLayout() );

        TableModel model = new SparseTableModel(row, column);
        JTable table = new JTable(model);
        table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        JScrollPane scrollPane = new JScrollPane( table );
        add( scrollPane );

        model.setValueAt("one", 0, 0);
        model.setValueAt("two", 5, 5);
    }

    class SparseTableModel extends AbstractTableModel
    {
        Map<Integer, Map<Integer, Object>> data = new HashMap<Integer, Map<Integer, Object>>();
        int rows;
        int columns;

        public SparseTableModel(int rows, int columns)
        {
            this.rows = rows;
            this.columns = columns;
        }

        @Override
        public int getRowCount() { return rows; }

        @Override
        public int getColumnCount() { return columns; }

        @Override
        public boolean isCellEditable(int row, int column) { return true; }

        @Override
        public Object getValueAt(int row, int column)
        {
            //  Check for row

            Integer key = new Integer(row);
            Map<Integer, Object> rows = data.get(key);

            if (rows == null) return null;

            //  Now check for column

            key = new Integer(column);
            return rows.get(key);
        }

        @Override
        public void setValueAt(Object value, int row, int column)
        {
            //  Remove cell data

            if (value.toString().equals(""))
            {
                removeCellData(row, column);
                return;
            }

            //  Save cell data

            Integer key = new Integer(row);
            Map<Integer, Object> rows = data.get(key);

            if (rows == null)
            {
                rows = new HashMap<Integer, Object>();
                data.put(key, rows);
            }

            key = new Integer(column);
            rows.put(key, value);
        }

        private void removeCellData(int row, int column)
        {
            Integer rowKey = new Integer(row);
            Map<Integer, Object> rows = data.get(rowKey);

            if (rows == null) return;

            Integer columnKey = new Integer(column);
            rows.remove(columnKey);

            if (rows.isEmpty())
                data.remove(rowKey);
        }

    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.add( new TableSparse(100, 256) );
        frame.setSize(600, 600);
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
    }
}