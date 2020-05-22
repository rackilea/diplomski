import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class RightSidePanel implements Runnable {

    @Override
    public void run() {
        JFrame frm = new JFrame("Right side panel");
        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // next two lines are not required
        JPanel contentPanel = new JPanel(new BorderLayout());
        frm.setContentPane(contentPanel);
        JPanel mainPanel = new JPanel(new CardLayout());
        mainPanel.add(new JLabel("It's the first card panel"), "first");
        mainPanel.add(new JLabel("It's the second card panel"), "second");
        // add some components to provide some width and height for the panel.
        mainPanel.add(Box.createHorizontalStrut(600));
        mainPanel.add(Box.createVerticalStrut(300));
        mainPanel.setBackground(Color.CYAN);
        JPanel settingsPanel = new JPanel(new GridLayout(1, 1));
        settingsPanel.add(new JLabel("Here is the settings panel!"));
        settingsPanel.setPreferredSize(
                new Dimension(settingsPanel.getPreferredSize().width, 300));
        ((JComponent) frm.getGlassPane()).setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        ((JComponent) frm.getGlassPane()).add(settingsPanel, BorderLayout.EAST);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        JButton settingsButton = new JButton("Show settings");
        settingsButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frm.getGlassPane().setVisible(!frm.getGlassPane().isVisible());
                if (frm.getGlassPane().isVisible()) {
                    settingsButton.setText("Hide settings");
                } else {
                    settingsButton.setText("Show settings");
                }
            }
        });
        JButton switchButton = new JButton("Show second");
        switchButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                if (mainPanel.getComponent(0).isVisible()) {
                    cl.show(mainPanel, "second");
                    switchButton.setText("Show first");
                } else {
                    cl.show(mainPanel, "first");
                    switchButton.setText("Show second");
                }
            }
        });
        buttonPanel.add(switchButton);
        buttonPanel.add(settingsButton);
        frm.add(mainPanel, BorderLayout.CENTER);
        frm.add(buttonPanel, BorderLayout.SOUTH);
        frm.pack();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new RightSidePanel());
    }
}