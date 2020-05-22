import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class TestTable11 {

    public static void main(String[] args) {
        new TestTable11();
    }

    public TestTable11() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                TableModel model = new SimpleTableModel();

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new JScrollPane(new JTable(model)));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class SimpleTableModel extends AbstractTableModel {

        private List<Object[]> rows;

        public SimpleTableModel() {
            rows = new ArrayList<>(5);
            rows.add(new Object[]{"Test1", "Test2", false});
            rows.add(new Object[]{"Test3", "Test4", false});
            rows.add(new Object[]{"Test5", "Test6", false});
            rows.add(new Object[]{"Test7", "Test8", false});
            rows.add(new Object[]{"Test9", "Test10", false});
            rows.add(new Object[]{"Test11", "Test11", false});
        }

        @Override
        public int getRowCount() {
            return rows.size();
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return rows.get(rowIndex)[columnIndex];
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex == 2;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return columnIndex < 2 ? String.class : Boolean.class;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            if (columnIndex == 2 && aValue instanceof Boolean) {
                rows.get(rowIndex)[columnIndex] = aValue;
            }
        }        
    }    
}