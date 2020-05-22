import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class TableFormatRenderDemo {

    public TableFormatRenderDemo() {
        JFrame frame = new JFrame();
        frame.add(new JScrollPane(createTable()));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /*
     * We are using all double values. We leave the rendering to 
     * the renderer. The NumberFormat is used to format the text.
     */
    private JTable createTable() {
        Object[][] data = new Object[][] {
                { "AUD", 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 },
                { "CAD", 0.0, 0.0, 0.0, 0.0, 45.00, -0.35 },
                { "CHF", 0.897, -1, 0.896, 0.0, -120.00, 0.00 },
                { "CHK", 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 },
                { "Total", null, null, null, null, 20125.00, 0.00 } };
        String[] cols = { "col 1", "col 2", "col 3", "col 4", "col 5", "col 6",
                "col 7" };
        DefaultTableModel model = new DefaultTableModel(data, cols);
        JTable table = new JTable(model) {
            @Override
            public Dimension getPreferredScrollableViewportSize() {
                return getPreferredSize();
            }
        };
        // Set the custom renerer
        table.setDefaultRenderer(Object.class, new NumberFormatRenderer());
        return table;
    }

    private NumberFormat getFormatter() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) formatter)
                .getDecimalFormatSymbols();
        decimalFormatSymbols.setCurrencySymbol("$");
        ((DecimalFormat) formatter)
                .setDecimalFormatSymbols(decimalFormatSymbols);
        return formatter;
    }

    /**
     * Custom renderer we use for the table
     */
    private class NumberFormatRenderer extends DefaultTableCellRenderer {
        private static final long serialVersionUID = 5152961981995932787L;
        private static final int PL_USD_COL = 5;
        private static final int DAILY_PL_COL = 6;
        // TODO We may want to have a setter for this formatter
        private final NumberFormat formatter = getFormatter();

        private final Color POSITIVE_COLOR = new Color(65, 185, 62);
        private final Color NEGATIVE_COLOR = Color.RED;
        private final Color LAST_ROW_COLOR = Color.CYAN;
        private final Color ALT_ROW_COLOR = Color.LIGHT_GRAY;

        public Component getTableCellRendererComponent(JTable table,
                Object value, boolean isSelected, boolean hasFocus, int row,
                int column) {
            super.getTableCellRendererComponent(table, value, isSelected,
                    hasFocus, row, column);

            renderAlternateBackground(row, table.getBackground(), table.getRowCount());
            renderForeground(row, column, table.getForeground(),
                    table.getRowCount(), value);

            // Formats the last row with the given NumberFormat
            if (row == table.getRowCount() - 1 && column != 0 && value != null) {
                setText(formatter.format((Double) value));
            }

            // Centers the text
            setHorizontalAlignment(CENTER);

            return this;
        }

        /**
         * Renders the foreground. Render only if column is one of 
         * the predefined "PL" columns, using the helper method
         * <code>getColor</code> to determine the color to render based on the 
         * <code>value</code>.
         *  
         * @param row
         * @param col
         * @param tableForeground
         * @param rowCount
         * @param value
         */
        private void renderForeground(int row, int col, Color tableForeground,
                int rowCount, Object value) {
            if (col == PL_USD_COL || col == DAILY_PL_COL) {
                setForeground(getColor((Double) value, tableForeground));
            } else {
                setForeground(tableForeground);
            }
        }

        /**
         * Helper method for the <code>renderForeground</code> method. Returns
         * a <code>Color</code> base on the value.
         * @param value
         * @param tableForeground
         * @return
         */
        private Color getColor(double value, Color tableForeground) {
            Color color = null;
            if (value > 0) {
                color = POSITIVE_COLOR;
            } else if (value < 0) {
                color = NEGATIVE_COLOR;
            } else {
                color = tableForeground;
            }
            return color;
        }

        /**
         * Rendered alternate background color. Check for odd rows numbers.
         * The last row is rendered as the select <code>LAST_ROW_COLOR</code> color.
         * @param row
         * @param tableBackground
         * @param rowCount
         */
        private void renderAlternateBackground(int row, Color tableBackground,
                int rowCount) {
            if (row % 2 != 0) {
                setBackground(ALT_ROW_COLOR);
            } else if (row == (rowCount - 1)) {
                setBackground(LAST_ROW_COLOR);
            } else {
                setBackground(tableBackground);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TableFormatRenderDemo();
            }
        });
    }
}