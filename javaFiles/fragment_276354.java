import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GridBagExample {
    private static final int SIZE = 10;
    private JButton[] buttons;

    public GridBagExample() {
        buttons = new JButton[SIZE];
    }

    private void createAndDisplayGUI() {
        JFrame frame = new JFrame("Grid Game");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(2, 1, 5, 5));
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel topPanel = new JPanel();
        JTextArea tArea = new JTextArea(5, 30);
        JScrollPane scroller = new JScrollPane();
        scroller.setViewportView(tArea);
        topPanel.add(scroller);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        JPanel headerPanel = new JPanel(new GridLayout(1, 0, 5, 5));
        buttons[0] = new JButton("A");
        headerPanel.add(buttons[0]);
        buttons[1] = new JButton("B");
        headerPanel.add(buttons[1]);
        buttons[2] = new JButton("C");
        headerPanel.add(buttons[2]);
        buttons[3] = new JButton("D");
        headerPanel.add(buttons[3]);
        buttons[4] = new JButton("E");
        headerPanel.add(buttons[4]);
        buttons[5] = new JButton("F");
        headerPanel.add(buttons[5]);
        JPanel footerPanel = new JPanel(new GridLayout(1, 0, 5, 5));
        buttons[6] = new JButton("WA");
        footerPanel.add(buttons[6]);
        buttons[7] = new JButton("WB");
        footerPanel.add(buttons[7]);
        buttons[8] = new JButton("WC");
        footerPanel.add(buttons[8]);
        buttons[9] = new JButton("WD");
        footerPanel.add(buttons[9]);
        buttonPanel.add(headerPanel);
        buttonPanel.add(footerPanel);

        contentPane.add(topPanel);
        contentPane.add(buttonPanel);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String... args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GridBagExample().createAndDisplayGUI();
            }
        });
    }
}