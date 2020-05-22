import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

public class TableSelectionGood implements ListSelectionListener {

    private JTable[] tables;
    private boolean ignore = false;

    public TableSelectionGood() {
        Object[][] data1 = new Object[100][5];
        Object[][] data2 = new Object[50][5];
        Object[][] data3 = new Object[50][5];
        for (int i = 0; i < data1.length; i++) {
            data1[i][0] = "Company # " + (i + 1);
            for (int j = 1; j < data1[i].length; j++) {
                data1[i][j] = "" + (i + 1) + ", " + j;
            }
        }
        for (int i = 0; i < data2.length; i++) {
            data2[i][0] = "Company # " + ((i * 2) + 1);
            for (int j = 1; j < data2[i].length; j++) {
                data2[i][j] = "" + ((i * 2) + 1) + ", " + j;
            }
        }
        for (int i = 0; i < data3.length; i++) {
            data3[i][0] = "Company # " + (i * 2);
            for (int j = 1; j < data3[i].length; j++) {
                data3[i][j] = "" + (i * 2) + ", " + j;
            }
        }
        String[] headers = {"Col 1", "Col 2", "Col 3", "Col 4", "Col 5"};
        DefaultTableModel model1 = new DefaultTableModel(data1, headers);
        DefaultTableModel model2 = new DefaultTableModel(data2, headers);
        DefaultTableModel model3 = new DefaultTableModel(data3, headers);
        final JTable jTable1 = new JTable(model1);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        final JScrollPane sp1 = new JScrollPane();
        sp1.setPreferredSize(new Dimension(600, 200));
        sp1.setViewportView(jTable1);
        final JTable jTable2 = new JTable(model2);
        jTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        final JScrollPane sp2 = new JScrollPane();
        sp2.setPreferredSize(new Dimension(600, 200));
        sp2.setViewportView(jTable2);
        final JTable jTable3 = new JTable(model3);
        jTable3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        final JScrollPane sp3 = new JScrollPane();
        sp3.setPreferredSize(new Dimension(600, 200));
        sp3.setViewportView(jTable3);
        TableSelectionGood tableSelection = new TableSelectionGood(jTable1, jTable2, jTable3);
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3, 0, 10, 10));
        panel1.add(sp1);
        panel1.add(sp2);
        panel1.add(sp3);
        JFrame frame = new JFrame("tableSelection");
        frame.add(panel1);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public TableSelectionGood(JTable... tables) {
        for (JTable table : tables) {
            table.getSelectionModel().addListSelectionListener(this);
        }
        this.tables = tables;
    }

    private JTable getTable(Object model) {
        for (JTable table : tables) {
            if (table.getSelectionModel() == model) {
                return table;
            }
        }
        return null;
    }

    private void changeSelection(JTable table, String rowKey) {
        int col = table.convertColumnIndexToView(0);
        for (int row = table.getRowCount(); --row >= 0;) {
            if (rowKey.equals(table.getValueAt(row, col))) {
                table.changeSelection(row, col, false, false);
                return;
            }
        }
        table.clearSelection();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() || ignore) {
            return;
        }
        ignore = true;
        try {
            JTable table = getTable(e.getSource());
            int row = table.getSelectedRow();
            String rowKey = table.getValueAt(row, table.convertColumnIndexToView(0)).toString();
            for (JTable t : tables) {
                if (t == table) {
                    continue;
                }
                changeSelection(t, rowKey);
                JViewport viewport = (JViewport) t.getParent();
                Rectangle rect = t.getCellRect(t.getSelectedRow(), 0, true);
                Rectangle r2 = viewport.getVisibleRect();
                t.scrollRectToVisible(new Rectangle(rect.x, rect.y, (int) r2.getWidth(), (int) r2.getHeight()));
                System.out.println(new Rectangle(viewport.getExtentSize()).contains(rect));
            }
        } finally {
            ignore = false;
        }
    }

    public static void main(String[] args) {
        TableSelectionGood tableSelection = new TableSelectionGood();
    }
}