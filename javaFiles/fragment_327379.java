import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

class FlowLayoutChangingGap {

    public static final int ROWS = 3;

    FlowLayoutChangingGap() {
        // just for testing perpose but data are getting from database and it's dynamic
        Object[][] data = {
            {"Kathy", "Smith", "Snowboarding", new Integer(5)},
            {"John", "Doe", "Rowing", new Integer(3)},
            {"Sue", "Black", "Knitting", new Integer(2)},
            {"Jane", "White", "Speed reading", new Integer(20)},
            {"Joe", "Brown", "Pool", new Integer(10)}};
        Object[] columnNames = {"firstname", "lastname", "age"};
        final JTable table = new JTable(data, columnNames) {

            @Override
            public Dimension getPreferredScrollableViewportSize() {
                Dimension d = getPreferredSize();
                // Note: margin is included in rowHeight
                int n = getRowHeight(); // + getRowMargin();
                // tbd: insets? we are one-off here
                return new Dimension(d.width, (n * ROWS));
            }
        };
        JPanel jPanel = new JPanel();
        jPanel.setBorder(new EmptyBorder(6, 6, 6, 6));
        jPanel.setLayout(new GridLayout());
        JScrollPane sp = new JScrollPane(table);
        //sp.getViewport().
        jPanel.add(sp);
        JDialog jdialog = new JDialog();
        jdialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jdialog.setContentPane(jPanel);

        jdialog.setLocationRelativeTo(null);
        jdialog.pack();
        jdialog.setVisible(true);
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                new FlowLayoutChangingGap();
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency
        SwingUtilities.invokeLater(r);
    }
}