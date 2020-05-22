import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableDemo {

    private JFrame jfrm = new JFrame("Table Demo");
    private String[] headings = {"From", "Address", "Subject", "Size"};
    private Object[][] data = {
        {"Wendy", "Wendy@HerbSchildt.com", "Hello Herb", new Integer(287)},
        {"Alex", "Alex@HerbSchildt.com", "Check this out!", new Integer(308)},
        {"Hale", "Hale@HerbSchildt.com", "Found a bug", new Integer(887)},
        {"Todd", "Todd@HerbSchildt.com", "Did you see this?", new Integer(223)},
        {"Steve", "Steve@HerbSchildt.com", "I'm back", new Integer(357)},
        {"Ken", "Ken@HerbSchildt.com", "Arrival time change", new Integer(512)}
    };
    private JTable table = new JTable(data, headings);
    private JScrollPane jsp = new JScrollPane(table);
    private JLabel jl;

    public TableDemo() {
        jl = new JLabel("whatever but not empty JLabel");
        jsp.getViewport().setBackground(Color.ORANGE);
        table.setOpaque(false); //
        table.setFillsViewportHeight(true);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.add(jsp);
        jfrm.add(jl, BorderLayout.NORTH);
        jfrm.pack();
        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TableDemo();
            }
        });
    }
}