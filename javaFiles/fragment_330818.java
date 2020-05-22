import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Circles {

    public static void main(String[] args) {
        new Circles();
    }

    public Circles() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            FontMetrics fm = g2d.getFontMetrics();
            int padding = fm.getHeight() + 4;
            int width = getWidth() - 1 - padding;
            int height = getHeight() - 1 - padding;

            int radius = Math.min(width, height);
            int x = (padding + (width - radius)) / 2;
            int y = (padding + (height - radius)) / 2;
            g2d.drawOval(x, y, radius, radius);

            String text = "This is a test";

            int centerX = (padding + radius) / 2;
            int centerY = (padding + radius) / 2;

            x = (centerX - (fm.stringWidth(text)) / 2);
            y = centerY - (radius / 2);
            g2d.drawString(text, x, y);

            x = centerX - (radius / 2);
            g2d.drawString(text, x, centerY);

            x = (centerX - (fm.stringWidth(text)) / 2);
            y = centerY + (radius / 2);
            g2d.drawString(text, x, y);

            x = (centerX - (fm.stringWidth(text)) / 2);
            y = centerY - (radius / 2);
            g2d.rotate(Math.toRadians(90), getWidth() / 2, getHeight() / 2);
            g2d.drawString(text, x, y);

            g2d.dispose();
        }
    }       
}