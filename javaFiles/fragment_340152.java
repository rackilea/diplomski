import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Basic {
    JFrame frame;
    JPanel panel;
    JLabel label;
    JButton button;

    public void createAndRun() {
        frame = new JFrame("Basic Example");

        setUp();
        frame.getContentPane().add(panel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void setUp() {
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        label = new JLabel("I am a JLabel");
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.weighty = 0;
        panel.add(label, c);

        button = new JButton("I am a JButton");
        c.gridx = 0;
        c.gridy = 1;
        c.weighty = 0.5;
        panel.add(button, c);
    }

    public static void main(String[] args) {
        Basic b = new Basic();
        b.createAndRun();
    }
}