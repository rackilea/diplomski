import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class Example extends JFrame {

    public Example() {

        List<Object[]> l = new ArrayList<Object[]>();
        l.add(new Object[]{true,1,2});
        l.add(new Object[]{true,3,4});

        MyTableModel model = new MyTableModel(new String[]{"1","2","3"},l);
        final JTable t = new JTable(model);
        t.getTableHeader().setReorderingAllowed(false);
        t.getModel().addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {
                if(e.getColumn() == 0 && e.getFirstRow()>-1){
                    System.out.println("Row : " + e.getFirstRow() +
                            " value :" + t.getValueAt(e.getFirstRow(), e.getColumn()));
                }
            }
        });
        add(new JScrollPane(t));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String args[]) {
        new Example();
    }

    class MyTableModel extends AbstractTableModel{

        private String[] columnNames;
        private List<Object[]> data;

        public MyTableModel(String[] columnNames, List<Object[]> data ){
            this.columnNames = columnNames;
            this.data = data;

        }

        @Override 
        public boolean isCellEditable(int row, int col){
            if(col == 0){
                return true;
            }
            return false;
        }
        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public int getRowCount() {
            return data.size();
        }
        public void setValueAt(Object value, int row, int col) {
            data.get(row)[col] = value;
            fireTableCellUpdated(row, col);
        }

        @SuppressWarnings({ "unchecked", "rawtypes" })
        public Class getColumnClass(int column) {
             if(column == 0){
                 return Boolean.class;
             }
            return (getValueAt(0, column).getClass());
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        @Override
        public Object getValueAt(int row, int col) {
            return data.get(row)[col];
        }
    }

}