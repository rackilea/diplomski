import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class SyncedTables {

    public static void main(String[] args) {
        new SyncedTables();
    }

    public SyncedTables() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JTable left;
        private JTable right;

        public TestPane() {

            setLayout(new GridLayout(1, 2));
            left = new JTable(createTableModel("L"));
            right = new JTable(createTableModel("R"));

            left.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            right.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

            JScrollPane leftScrollPane = new JScrollPane(left);
            JScrollPane rightScrollPane = new JScrollPane(right);

            AdjustmentHandler ah = new AdjustmentHandler(leftScrollPane, rightScrollPane);

            leftScrollPane.getVerticalScrollBar().addAdjustmentListener(ah);
            leftScrollPane.getHorizontalScrollBar().addAdjustmentListener(ah);
            rightScrollPane.getVerticalScrollBar().addAdjustmentListener(ah);
            rightScrollPane.getHorizontalScrollBar().addAdjustmentListener(ah);

            SelectionHandler sh = new SelectionHandler(left, right);
            left.getSelectionModel().addListSelectionListener(sh);
            right.getSelectionModel().addListSelectionListener(sh);

            add(leftScrollPane);
            add(rightScrollPane);

        }

        protected TableModel createTableModel(String prefix) {
            DefaultTableModel model = new DefaultTableModel(0, 50);
            for (int row = 0; row < 100; row++) {
                Object[] rowData = new Object[50];
                for (int col = 0; col < 50; col++) {
                    rowData[col] = prefix + "-" + row + "x" + col;
                }
                model.addRow(rowData);
            }
            return model;
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }
    }

    public class SelectionHandler implements ListSelectionListener {

        private JTable left;
        private JTable right;
        private boolean ignore;

        public SelectionHandler(JTable left, JTable right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!ignore) {
                ignore = true;
                if (e.getSource() == left.getSelectionModel()) {
                    sync(left, right);
                } else if (e.getSource() == right.getSelectionModel()) {
                    sync(left, right);
                }
                ignore = false;
            }
        }

        protected void sync(JTable master, JTable slave) {
            slave.clearSelection();
            int[] selectedRows = master.getSelectedRows();
            for (int row : selectedRows) {
                slave.addRowSelectionInterval(row, row);
            }
            int[] selectedColumns = master.getSelectedColumns();
            for (int cols : selectedColumns) {
                slave.addColumnSelectionInterval(cols, cols);
            }
        }
    }

    public class AdjustmentHandler implements AdjustmentListener {

        private JScrollPane left;
        private JScrollPane right;
        private boolean ignore;

        public AdjustmentHandler(JScrollPane left, JScrollPane right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public void adjustmentValueChanged(AdjustmentEvent e) {
            if (!ignore) {
                ignore = true;
                Container parent = ((Component) e.getSource()).getParent();
                if (parent == left) {
                    sync(left, right);
                } else if (parent == right) {
                    sync(right, left);
                }
                ignore = false;
            }
        }

        protected void sync(JScrollPane master, JScrollPane slave) {
            slave.getHorizontalScrollBar().setValue(master.getHorizontalScrollBar().getValue());
            slave.getVerticalScrollBar().setValue(master.getVerticalScrollBar().getValue());
        }
    }
}