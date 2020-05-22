import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * 
 * @author mt
 */
public class MainView extends JFrame {

    public MainView() {
        setPreferredSize(new Dimension(500, 500));
        getContentPane().setLayout(new BorderLayout());
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.YELLOW);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(4, 4, 4, 4);
        panel.add(new JLabel("PokerStars"), c);

        panel.add(new JTextField(20), c);

        c.gridwidth = GridBagConstraints.REMAINDER;
        panel.add(new JButton("btn"), c);
        c.gridwidth = 1;

        panel.add(new JLabel("Full Tilt Poker"), c);

        panel.add(new JTextField(20), c);

        c.gridwidth = GridBagConstraints.REMAINDER;
        panel.add(new JButton("btn"), c);
        c.weighty = 1.0;
        panel.add(Box.createGlue(), c);

        add(panel, BorderLayout.LINE_START);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainView();
            }
        });
    }
}