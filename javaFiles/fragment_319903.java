import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class PanelTest {
    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                PanelTest test = new PanelTest();
                test.createUI();
            }
        };
        SwingUtilities.invokeLater(runnable);
    }

    public void createUI(){
        JFrame frame = new JFrame("Panel Test");

        JPanel panel = new JPanel();

        panel.setBackground(new Color(213, 134, 145, 123));
        JButton button = new JButton("I am a button");

        JLabel label = new JLabel("I am a label");
        label.setFont(new Font("Arial", Font.BOLD, 15));

        JTextField textField = new JTextField();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(button);
        panel.add(Box.createVerticalStrut(20));
        panel.add(label);
        panel.add(Box.createVerticalStrut(20));
        panel.add(textField);

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        BottomPanel buttomPanel = new BottomPanel();
        buttomPanel.add(panel);
        frame.add(buttomPanel,BorderLayout.CENTER);

        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @SuppressWarnings("serial")
    class BottomPanel extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            for (int y = 0; y < 200; y = y + 20) {
                g.drawString("I am the string on the bottom", 5, y);
            }
        }
    }
}