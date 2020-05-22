import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestTableHeader {

    protected void initUI() {
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        Vector<String> colNames = new Vector<String>();
        for (int i = 0; i < 5; i++) {
            colNames.add("Col-" + (i + 1));
        }

        table = new JTable(data, colNames);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scrollpane = new JScrollPane();
        scrollpane.setColumnHeaderView(table.getTableHeader());
        scrollpane.setViewportView(new JLabel("some label in the viewport view"));
        frame.add(scrollpane, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    private JTable table;
    private JScrollPane scrollpane;

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestTableHeader().initUI();
            }
        });
    }

}