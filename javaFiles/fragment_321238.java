import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class GbcLayout {

    private JFrame frame = new JFrame("GbcLayoutGbcLayout");
    private JPanel panel = new JPanel();
    private JLabel hidelLabel;
    private JLabel firstLabel;
    private JTextField firstText;

    public GbcLayout() {
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        for (int k = 0; k < 50; k++) {
            hidelLabel = new JLabel("     ");
            hidelLabel.setOpaque(true);
            hidelLabel.setBackground(Color.orange);
            hidelLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.weightx = 0.5;
            gbc.weighty = 0.5;
            gbc.gridx = k;
            gbc.gridy = 0;
            panel.add(hidelLabel, gbc);
        }
        for (int k = 0; k < 5; k++) {
            firstLabel = new JLabel("Testing Label : ", SwingConstants.RIGHT);
            firstLabel.setFont(new Font("Serif", Font.BOLD, 20));
            firstLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(0, 0, 5, 0);
            gbc.gridx = 0;
            gbc.gridwidth = 8;
            gbc.gridy = k + 1;
            panel.add(firstLabel, gbc);
        }
        for (int k = 0; k < 5; k++) {
            firstText = new JTextField("Testing TextField");
            firstText.setFont(new Font("Serif", Font.BOLD, 20));
            firstText.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(0, 0, 5, 0);
            gbc.gridx = 9;
            gbc.gridwidth = k + 8;
            gbc.gridy = k + 1;
            panel.add(firstText, gbc);
        }
        for (int k = 0; k < 5; k++) {
            firstLabel = new JLabel("Testing Label : ", SwingConstants.RIGHT);
            firstLabel.setFont(new Font("Serif", Font.BOLD, 20));
            firstLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(0, 0, 5, 0);
            gbc.gridx = 20 + k;
            gbc.gridwidth = 8;
            gbc.gridy = k + 1;
            panel.add(firstLabel, gbc);
        }
        for (int k = 0; k < 5; k++) {
            firstText = new JTextField("Testing TextField");
            firstText.setFont(new Font("Serif", Font.BOLD, 20));
            firstText.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(0, 0, 5, 0);
            gbc.gridx = 29 + k;
            gbc.gridwidth = 21 - k;
            gbc.gridy = k + 1;
            panel.add(firstText, gbc);
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                GbcLayout gbcl = new GbcLayout();
            }
        });
    }
}