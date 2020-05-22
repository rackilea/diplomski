import java.awt.Component;
import java.util.ArrayList;

import javax.swing.AbstractCellEditor;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;


public class TableEditingTest
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new TableEditingTest().createAndShowGUI();
            }
        });
    }

    private void createAndShowGUI()
    {
        JFrame frame = new JFrame("Table editing test");

        MyTableModel model = new MyTableModel();
        model.addRow(new String[]{"Some values", "so we have", "an actual table."});
        model.addRow(new String[]{"This table", "is inititalized", "with an empty row:"});
        model.createNewRow();

        MyTable table = new MyTable(model);

        table.setDefaultEditor(String.class, new MyStringTableCellEditor());

        frame.add(new JScrollPane(table));

        frame.setSize(600, 400); //use frame.pack() in a real application
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private class MyTable extends JTable
    {
        public MyTable(MyTableModel model)
        {
            super(model);
        }

        @Override
        public MyTableModel getModel()
        {
            return (MyTableModel) super.getModel();
        }

        @Override
        public void editingStopped(ChangeEvent e) 
        {
            int row = getEditingRow();
            int col = getEditingColumn();
            super.editingStopped(e);
            if (row == getRowCount() - 1 && col == getColumnCount() - 1)
            {
                getModel().createNewRow();
            }   
        };
    }

    private class MyTableModel extends AbstractTableModel
    {
        private static final int NUMBER_OF_COLUMNS = 3;
        private ArrayList<String[]> values;


        public MyTableModel()
        {
            values = new ArrayList<String[]>();
        }

        @Override
        public String getColumnName(int col)
        {
            return "Column " + col;
        }

        @Override
        public int getColumnCount()
        {
            return NUMBER_OF_COLUMNS;
        }

        @Override
        public int getRowCount()
        {
            return values.size();
        }

        @Override
        public Class<?> getColumnClass(int col)
        {
            return String.class;
        }

        @Override
        public boolean isCellEditable(int row, int col) 
        {
            return true;
        };

        @Override
        public Object getValueAt(int row, int col)
        {
            return values.get(row)[col];
        }

        public void createNewRow()
        {
            addRow(null);
        }

        public void addRow(String[] rowValues)
        {
            if (rowValues == null) 
            {
                values.add(new String[3]);
                fireTableDataChanged();
            }
            else if (rowValues.length == 3)
            {
                values.add(rowValues);
                fireTableDataChanged();
            }
            else throw new IllegalArgumentException("Expected an array of " + NUMBER_OF_COLUMNS + " strings, got " + rowValues.length + ".");
        }

        @Override
        public void setValueAt(Object value, int row, int col)
        {
            values.get(row)[col] = value.toString();
        }
    }

    private class MyStringTableCellEditor extends AbstractCellEditor implements TableCellEditor
    {
        private JTextField editorField = new JTextField();

        @Override
        public Object getCellEditorValue()
        {
            return editorField.getText();
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
        {
            editorField.setText((String) value);
            return editorField;
        }
    }

}