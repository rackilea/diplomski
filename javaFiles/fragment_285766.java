import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Test {

    public Test() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                Object rows[][] = {{"A", 1}, {"A", 2}, {"B", 1}, {"B", 2}, {"C", 1}, {"C", 2}, {"D", 4}, {"E", 5},
                    {"F", 6}};
                String columns[] = {"Foo", "Bar"};

                TableModel model = new DefaultTableModel(rows, columns) {
                    @Override
                    public Class getColumnClass(int column) {
                        Class returnValue;
                        if ((column >= 0) && (column < getColumnCount())) {
                            returnValue = getValueAt(0, column).getClass();
                        } else {
                            returnValue = Object.class;
                        }
                        return returnValue;
                    }
                };

                JTable table = new JTable(model);

                RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
                table.setRowSorter(sorter);

                table.setPreferredScrollableViewportSize(table.getPreferredSize());
                JScrollPane pane = new JScrollPane(table);

                frame.add(pane);

                frame.pack();
                frame.setVisible(true);

            }
        });
    }

    public static void main(String[] args) {
        new Test();
    }
}