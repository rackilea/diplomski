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
        final JTable jTable3 = new TableBackroundPaint0(data1, headers);
        //final JTable jTable3 = new JTable(data1, headers);
        jTable3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable3.setModel(model1);
        final JScrollPane sp3 = new JScrollPane();
        sp3.setViewportView(jTable3);
        jTable3.setIntercellSpacing(new Dimension(0, 0));
        jTable3.setShowGrid(false);
        //jTable3.setPreferredScrollableViewportSize(jTable3.getPreferredSize());
        JFrame frame = new JFrame("tableSelection");
        frame.add(sp3);
        frame.setSize(new Dimension(600, 200));
        //frame.pack();
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