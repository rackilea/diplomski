import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class TableRenderer extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTable table;
    private String[] columnNames = {"Date", "String", "Centered", "Integer", "Boolean"};
    private Object[][] data = {
        {new Date(), "A", "A", new Integer(1), true},
        {new Date(), "B", "B", new Integer(2), false},
        {new Date(), "C", "C", new Integer(10), null},
        {new Date(), "D", "D", new Integer(4), false}
    };

    public TableRenderer() {
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table = new JTable(model) {

            private static final long serialVersionUID = 1L;
            //  Returning the Class of each column will allow different
            //  renderers to be used based on Class

            @Override
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        //  Override default renderer on a specific Class
        TableCellRenderer colorRenderer = new ColorRenderer();
        table.setDefaultRenderer(String.class, colorRenderer);

        //  Override default renderer for a specific column
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                TableRenderer frame = new TableRenderer();
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    /*
     **  Color the focused cell
     */
    private class ColorRenderer extends DefaultTableCellRenderer {

        private static final long serialVersionUID = 1L;

        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (hasFocus) {
                setBackground(Color.cyan);
            } else if (isSelected) {
                setBackground(table.getSelectionBackground());
            } else {
                setBackground(table.getBackground());
            }
            return this;
        }
    }
}