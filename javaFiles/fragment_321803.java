import java.awt.*;

import javax.swing.*;
import javax.swing.plaf.LayerUI;

/**
 * Example of rotation using {@link JLayer} in Java7.
 */
public class TiltedApproach {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Tilted components");
                LayerUI<JComponent> layerUI = new RotateUI();
                JPanel panel = new MyPanel();
                JLayer<JComponent> jLayer = new JLayer<JComponent>(panel, layerUI);
                frame.getContentPane().add(jLayer);
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setMinimumSize(new Dimension(800, 450));
                frame.setLocationRelativeTo(null); // Center
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    static class MyPanel extends JPanel {

        MyPanel() {
            add(new JLabel("Hello"));
            add(new JLabel("World"));
        }
    }

    static class RotateUI extends LayerUI<JComponent> {
        @Override
        public void paint(Graphics g, JComponent c) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.rotate(0.4);
            super.paint(g2, c);
            g2.dispose();
        }
    }
}