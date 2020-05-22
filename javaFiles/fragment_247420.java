import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SimpleTableDemo extends JPanel {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(SimpleTableDemo::createAndShowGUI);
    }

    private int
            hoveredRow = -1,
            hoveredColumn = -1;

    SimpleTableDemo() {
        super(new GridLayout(1,0));

        String[] columnNames = {"First Name", "Last Name", "Sport", "# of Years", "Vegetarian"};

        Object[][] data = {
                {"Kathy", "Smith", "Snowboarding", 5, Boolean.FALSE},
                {"John", "Doe", "Rowing", 3, Boolean.TRUE},
                {"Sue", "Black", "Knitting", 2, Boolean.FALSE},
                {"Jane", "White", "Speed reading", 20, Boolean.TRUE},
                {"Joe", "Brown", "Pool", 10, Boolean.FALSE}
        };

        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        table.getColumn("Sport").setCellRenderer(new MyCellRenderer());

        table.addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent e) {
                Point p = e.getPoint();
                hoveredRow = table.rowAtPoint(p);
                hoveredColumn = table.columnAtPoint(p);
                table.repaint();
            }
            public void mouseExited(MouseEvent e) {
                hoveredRow = hoveredColumn = -1;
                table.repaint();
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("SimpleTableDemo");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        SimpleTableDemo newContentPane = new SimpleTableDemo();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }

    private class MyCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (hoveredColumn == column && hoveredRow == row) {
                label.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
            }
            else {
                label.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
            }
            return label;
        }
    }

}