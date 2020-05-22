import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class Test {
    public static void main(String[] args) {
        SwingUtilities.invokeLater( () -> {
            JFrame frame = new JFrame();
            JPanel panel = new JPanel() {
                JLabel label = new JLabel("<html>SwingUtilities.paintComponent method usage example");
                {
                    label.setBorder(new LineBorder(Color.red));
                }
                protected void paintComponent(Graphics g) {
                    // render label which is not part of component hierarchy
                    // and paint it on this panel at location (10,10) with dimension (200,50)
                    SwingUtilities.paintComponent(g, label, this,  10, 10, 200, 50);
                }
            };
            frame.setContentPane(panel);
            frame.setSize(300, 200);
            frame.setVisible(true);
        });
    }
}