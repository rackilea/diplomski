import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.DefaultTableModel;

public class Example {

    public static void main(String[] args) {
        new Example();
    }

    public Example() {
        JFrame frame = new JFrame("Rotation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTable t = new JTable(new DefaultTableModel(new Object[][]{{1,2}},new Object[]{"1","2"}));
        final JTable t1 = new JTable(new DefaultTableModel(new Object[][]{{1,2}},new Object[]{"1","2"}));

        frame.getContentPane().add(new JScrollPane(t),BorderLayout.WEST);
        frame.getContentPane().add(new JScrollPane(t1),BorderLayout.EAST);

        t.getColumnModel().addColumnModelListener(new TableColumnModelListener() {

            @Override
            public void columnSelectionChanged(ListSelectionEvent arg0) {
            }

            @Override
            public void columnRemoved(TableColumnModelEvent arg0) {
            }

            @Override
            public void columnMoved(TableColumnModelEvent arg0) {
                int fromIndex = arg0.getFromIndex();
                int toIndex = arg0.getToIndex();
                t1.moveColumn(fromIndex, toIndex);
            }

            @Override
            public void columnMarginChanged(ChangeEvent arg0) {
            }

            @Override
            public void columnAdded(TableColumnModelEvent arg0) {
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

}