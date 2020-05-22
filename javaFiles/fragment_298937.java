import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class CandyStrippedTable {

    public static void main(String[] args) {
        new CandyStrippedTable();
    }

    public CandyStrippedTable() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                Object[] columns = new Object[10];
                for (int col = 0; col < columns.length; col++) {
                    columns[col] = (char) (65 + col);
                }

                Object[][] data = new Object[10][10];
                for (int row = 0; row < data.length; row++) {
                    for (int col = 0; col < data[row].length; col++) {
                        data[row][col] = row + "x" + col;
                    }
                }

                DefaultTableModel model = new DefaultTableModel(data, columns);
                JTable table = new JTable(model);
                table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

                    @Override
                    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                        setOpaque(isSelected);
                        return this;
                    }

                });
                table.setFillsViewportHeight(true);
                table.setOpaque(false);

                JScrollPane sp = new JScrollPane();
                sp.setViewport(new CandyStrippedViewPort(new Color(255, 0, 0, 128)));
                sp.setViewportView(table);

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(sp);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class CandyStrippedViewPort extends JViewport {

        private Color candyStrippedColor;

        public CandyStrippedViewPort(Color color) {
            candyStrippedColor = color;
        }

        public Color getCandyStrippedColor() {
            return candyStrippedColor;
        }

        public void setCandyStrippedColor(Color candyStrippedColor) {
            this.candyStrippedColor = candyStrippedColor;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(getCandyStrippedColor());
            Component view = getView();
            if (view instanceof JTable) {
                JTable table = (JTable) view;
                Rectangle viewRect = getViewRect();
                int y = 0;
                int row = 0;
                if (table.getRowCount() > 0) {
                    row = table.rowAtPoint(viewRect.getLocation());
                    while (row < table.getRowCount()) {
                        int rowHeight = table.getRowHeight(row);
                        Rectangle cellRect = table.getCellRect(row, 0, true);
                        if (row % 2 == 0) {
                            g2d.fillRect(0, cellRect.y - viewRect.y, getWidth(), cellRect.height);
                        }
                        y = cellRect.y + cellRect.height;
                        row++;
                    }
                }
                int rowHeight = table.getRowHeight();
                while (y < getHeight()) {
                    if (row % 2 == 0) {
                        g2d.fillRect(0, y, getWidth(), rowHeight);
                    }
                    row++;
                    y += rowHeight;
                }
            }
            g2d.dispose();
        }
    }
}