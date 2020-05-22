import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GridBagExample {
    private static final int SIZE = 10;
    private JButton[] buttons;
    private GridBagConstraints gbc;

    public GridBagExample() {
        buttons = new JButton[SIZE];
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
    }

    private void createAndDisplayGUI() {
        JFrame frame = new JFrame("Grid Game");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(2, 1, 5, 5));
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel topPanel = new JPanel();
        JTextField textField = new JTextField(10);
        //topPanel.add(textField);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        JPanel headerPanel = new JPanel(new GridBagLayout());
        buttons[0] = new JButton("A");
        addComp(headerPanel, buttons[0], 0, 0, 0.16, 1.0, 1, 1, GridBagConstraints.BOTH);        
        buttons[1] = new JButton("B");
        addComp(headerPanel, buttons[1], 1, 0, 0.16, 1.0, 1, 1, GridBagConstraints.BOTH);
        buttons[2] = new JButton("C");
        addComp(headerPanel, buttons[2], 2, 0, 0.16, 1.0, 1, 1, GridBagConstraints.BOTH);
        buttons[3] = new JButton("D");
        addComp(headerPanel, buttons[3], 3, 0, 0.16, 1.0, 1, 1, GridBagConstraints.BOTH);
        buttons[4] = new JButton("E");
        addComp(headerPanel, buttons[4], 4, 0, 0.16, 1.0, 1, 1, GridBagConstraints.BOTH);
        buttons[5] = new JButton("F");
        addComp(headerPanel, buttons[5], 5, 0, 0.16, 1.0, 1, 1, GridBagConstraints.BOTH);

        JPanel footerPanel = new JPanel(new GridBagLayout());
        buttons[6] = new JButton("WA");
        addComp(footerPanel, buttons[6], 0, 0, 0.25, 1.0, 1, 1, GridBagConstraints.BOTH);
        buttons[7] = new JButton("WB");
        addComp(footerPanel, buttons[7], 1, 0, 0.25, 1.0, 1, 1, GridBagConstraints.BOTH);
        buttons[8] = new JButton("WC");
        addComp(footerPanel, buttons[8], 2, 0, 0.25, 1.0, 1, 1, GridBagConstraints.BOTH);
        buttons[9] = new JButton("WD");
        addComp(footerPanel, buttons[9], 3, 0, 0.25, 1.0, 1, 1, GridBagConstraints.BOTH);
        buttonPanel.add(headerPanel);
        buttonPanel.add(footerPanel);

        contentPane.add(textField);
        contentPane.add(buttonPanel);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private void addComp(JPanel panel, JComponent comp, int x, int y,
                                    double wx, double wy, int gw, int gh, int fill) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.weightx = wx;
        gbc.weighty = wy;
        gbc.gridwidth = gw;
        gbc.gridheight = gh;
        gbc.fill = fill;

        panel.add(comp, gbc);
    }

    public static void main(String... args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GridBagExample().createAndDisplayGUI();
            }
        });
    }
}