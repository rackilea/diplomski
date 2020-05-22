import java.awt.Container;
import java.awt.Point;
import java.util.EventObject;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

public class TestTable {

    public JFrame f;
    private JLabel tooltip;
    private MyTable table;

    public class MyTable extends JTable {

        @Override
        public boolean editCellAt(int row, int column, EventObject e) {
            boolean editCellAt = super.editCellAt(row, column, e);
            if (editCellAt) {
                Point editedCellLocation = getCellRect(getEditingRow(), getEditingColumn(), true).getLocation();
                if (tooltip != null) {
                    removeTooltip();
                }
                tooltip = new JLabel("Hello some nice tooltip");
                tooltip.setOpaque(true);
                tooltip.setSize(tooltip.getPreferredSize());
                if (getEditingRow() == 0) {
                    tooltip.setLocation(editedCellLocation.x, getTableHeader().getHeight() - tooltip.getHeight());
                    getTableHeader().add(tooltip);
                } else {
                    tooltip.setLocation(editedCellLocation.x, editedCellLocation.y - tooltip.getHeight());
                    add(tooltip);
                }
                ((JComponent) tooltip.getParent()).repaint(tooltip.getBounds());
            }
            return editCellAt;
        }

        @Override
        public void editingStopped(ChangeEvent e) {
            super.editingStopped(e);
            removeTooltip();
        }

        protected void removeTooltip() {
            if (tooltip != null) {
                Container parent = tooltip.getParent();
                parent.remove(tooltip);
                ((JComponent) parent).repaint(tooltip.getBounds());
                tooltip = null;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestTable().initUI();
            }
        });
    }

    protected void initUI() {
        table = new MyTable();
        table.setModel(new TestTableModel());
        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 300);
        f.setLocationRelativeTo(null);
        f.add(new JScrollPane(table));
        f.setVisible(true);
    }

    public class TestTableModel extends DefaultTableModel {

        public TestTableModel() {
            super(new String[] { "DATA" }, 3);
            setValueAt(Double.valueOf(-0.1), 0, 0);
            setValueAt(Double.valueOf(+0.1), 1, 0);
            setValueAt(Double.valueOf(0), 2, 0);
        }
    }

}