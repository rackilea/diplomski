import java.awt.*;

import javax.swing.*;


public class FrameTest {

    public static void main(String[] args) {
        final JFrame f = new JFrame("Frame Test");

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        panel.add(new JTextField(), gbc);


        JPanel numSysPanel = new JPanel(new GridLayout(1, 3));
        numSysPanel.setBorder(BorderFactory.createTitledBorder("Number System"));
        numSysPanel.add(new JRadioButton("oct"));
        numSysPanel.add(new JRadioButton("dec"));
        numSysPanel.add(new JRadioButton("hex"));
        panel.add(numSysPanel, gbc);

        JPanel buttons = new JPanel(new GridLayout(4, 4, 2, 2));
        for (int i = 0; i < 16; i++)
            buttons.add(new JButton("" + i));
        panel.add(buttons, gbc);

        f.setContentPane(panel);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}