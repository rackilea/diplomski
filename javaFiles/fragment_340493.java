import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListLocation extends JFrame {

    private JList<String> list;
    private static String[] colorname = {"black", "blue", "red", "white"};
    private static Color[] colors = {Color.BLACK, Color.BLUE, Color.RED, Color.WHITE};

    public ListLocation() {
        super("title");

        FlowLayout layout = new FlowLayout();
        layout.setAlignment(FlowLayout.LEFT);

        list = new JList<String>(colorname);
        list.setVisibleRowCount(10);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        setLayout(layout);
        add(list);

        list.addListSelectionListener(
                new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                getContentPane().setBackground(colors[list.getSelectedIndex()]);
            }
        }
        );

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ListLocation();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}