import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class RowSorterTest {

    public static void main(String[] args) {
        new RowSorterTest();
    }

    public RowSorterTest() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                DefaultTableModel model = new DefaultTableModel(new String[]{"B1", "B2", "A1", "A2"}, 0);
                for (int index = 0; index < 100; index++) {
                    model.addRow(new Object[]{rnd(), rnd(), rnd(), rnd()});
                }
                JTable table = new JTable(model);
                RowSorter sorter = new MyRowSorter(model);
                table.setRowSorter(sorter);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class MyRowSorter extends TableRowSorter<TableModel> {

        public MyRowSorter(TableModel model) {
            super(model);
        }

        @Override
        public void setSortKeys(List<? extends SortKey> sortKeys) {
            List<SortKey> newKeys = new ArrayList<>(sortKeys.size());
            for (SortKey key : sortKeys) {
                if (key.getColumn() >= 0 && key.getColumn() <= 1) {
                    newKeys.add(key);
                }
            }
            super.setSortKeys(newKeys); 
        }

    }

    protected int rnd() {

        return (int)(Math.random() * 100d);

    }

}