import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TableExample {

    public TableExample() {
        Object[][] data1 = new Object[50][5];
        for (int i = 0; i < data1.length; i++) {
            data1[i][0] = "Company # " + (i + 1);
            for (int j = 1; j < data1[i].length; j++) {
                data1[i][j] = "" + (i + 1) + ", " + j;
            }
        }
        String[] headers = {"Col 1", "Col 2", "Col 3", "Col 4", "Col 5"};
        DefaultTableModel model1 = new DefaultTableModel(data1, headers);
        final JTable jTable1 = new JTable(model1);
        jTable1.setBackground(Color.orange);
        jTable1.setForeground(Color.blue);
        jTable1.setRowHeight(24);
        jTable1.setFont(new Font("Arial", Font.BOLD, 12));
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        final JScrollPane sp1 = new JScrollPane();
        sp1.setPreferredSize(new Dimension(600, 200));
        sp1.setViewportView(jTable1);
        final JTable jTable2 = new JTable(model1);
        jTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        final JScrollPane sp2 = new JScrollPane();
        sp2.setPreferredSize(new Dimension(600, 200));
        sp2.setViewportView(jTable2);
        final JTable jTable3 = new TableBackroundPaint0(data1, headers);
        jTable3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable3.setModel(model1);
        final JScrollPane sp3 = new JScrollPane();
        sp3.setPreferredSize(new Dimension(600, 200));
        sp3.setViewportView(jTable3);
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                TableExample te = new TableExample();
            }
        });
    }
}

class TableBackroundPaint0 extends JTable {

    private static final long serialVersionUID = 1L;

    TableBackroundPaint0(Object[][] data, Object[] head) {
        super(data, head);
        setOpaque(false);
        ((JComponent) getDefaultRenderer(Object.class)).setOpaque(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        Color background = new Color(168, 210, 241);
        Color controlColor = new Color(230, 240, 230);
        int width = getWidth();
        int height = getHeight();
        Graphics2D g2 = (Graphics2D) g;
        Paint oldPaint = g2.getPaint();
        g2.setPaint(new GradientPaint(0, 0, background, width, 0, controlColor));
        g2.fillRect(0, 0, width, height);
        g2.setPaint(oldPaint);
        for (int row : getSelectedRows()) {
            Rectangle start = getCellRect(row, 0, true);
            Rectangle end = getCellRect(row, getColumnCount() - 1, true);
            g2.setPaint(new GradientPaint(start.x, 0, controlColor, (int) ((end.x + end.width - start.x) * 1.25), 0, Color.orange));
            g2.fillRect(start.x, start.y, end.x + end.width - start.x, start.height);
        }
        super.paintComponent(g);
    }
}