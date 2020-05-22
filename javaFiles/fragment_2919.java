import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GalaxyTable2 extends JPanel {

    private static final int PREF_W = 700;
    private static final int PREF_H = 600;

    String[] columnNames
                    = {"Phone Name", "Brief Description", "Picture", "price",
                        "Buy"};

// Create image icons
    ImageIcon Image1 = new ImageIcon(
                    getClass().getResource("s1.png"));
    ImageIcon Image2 = new ImageIcon(
                    getClass().getResource("s2.png"));
    ImageIcon Image3 = new ImageIcon(
                    getClass().getResource("s3.png"));
    ImageIcon Image4 = new ImageIcon(
                    getClass().getResource("s4.png"));
    ImageIcon Image5 = new ImageIcon(
                    getClass().getResource("note.png"));
    ImageIcon Image6 = new ImageIcon(
                    getClass().getResource("note2.png"));
    ImageIcon Image7 = new ImageIcon(
                    getClass().getResource("note3.png"));

    Object[][] rowData = {
        {"Galaxy S", "3G Support,CPU 1GHz",
            Image1, 120, false},
        {"Galaxy S II", "3G Support,CPU 1.2GHz",
            Image2, 170, false},
        {"Galaxy S III", "3G Support,CPU 1.4GHz",
            Image3, 205, false},
        {"Galaxy S4", "4G Support,CPU 1.6GHz",
            Image4, 230, false},
        {"Galaxy Note", "4G Support,CPU 1.4GHz",
            Image5, 190, false},
        {"Galaxy Note2 II", "4G Support,CPU 1.6GHz",
            Image6, 190, false},
        {"Galaxy Note 3", "4G Support,CPU 2.3GHz",
            Image7, 260, false},};

    MyTable ss = new MyTable(
                    rowData, columnNames);

    // Create a table
    JTable jTable1 = new JTable(ss);

    public GalaxyTable2() {
        jTable1.setRowHeight(70);

        add(new JScrollPane(jTable1),
                        BorderLayout.CENTER);

        JPanel buttons = new JPanel();

        JButton button = new JButton("Home");
        buttons.add(button);
        JButton button2 = new JButton("Confirm");
        buttons.add(button2);

        add(buttons, BorderLayout.SOUTH);
    }

    @Override

    public Dimension getPreferredSize() {
        return new Dimension(PREF_W, PREF_H);
    }

    public void actionPerformed(ActionEvent e) {
        new AMainFrame7().setVisible(true);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new GalaxyTable2());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}