import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class DrawTest {

    private interface GraphicsAction {

        public void action(Graphics g);
    }

    private static class TestPanel extends JPanel {

        private GraphicsAction paintAction;
        private BufferedImage buffer;

        @Override
        public void invalidate() {
            BufferedImage img = new BufferedImage(
                    Math.max(1, getWidth()),
                    Math.max(1, getHeight()), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = img.createGraphics();
            g2d.setColor(getBackground());
            g2d.fillRect(0, 0, getWidth(), getHeight());
            if (buffer != null) {
                g2d.drawImage(buffer, 0, 0, this);
            }
            g2d.dispose();
            buffer = img;
            super.invalidate();
        }

        protected BufferedImage getBuffer() {
            if (buffer == null) {
                buffer = new BufferedImage(
                        Math.max(1, getWidth()),
                        Math.max(1, getHeight()), BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = buffer.createGraphics();
                g2d.setColor(getBackground());
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.dispose();
            }
            return buffer;
        }

        public void draw(GraphicsAction action) {
            BufferedImage buffer = getBuffer();
            Graphics2D g2d = buffer.createGraphics();
            action.action(g2d);
            g2d.dispose();
            repaint();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(getBuffer(), 0, 0, this);
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("DrawTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));

        TestPanel p = new TestPanel();
        frame.getContentPane().add(p);
        frame.pack();
        frame.setVisible(true);
        p.repaint();

        p.draw(new GraphicsAction() {
            public void action(Graphics g) {
                g.setColor(Color.RED);
                g.drawLine(5, 30, 100, 50);
            }
        });

        // in real life, we would do some other stuff and then
        // later something would want to add a blue line to the
        // diagram 
        p.draw(new GraphicsAction() {
            public void action(Graphics g) {
                g.setColor(Color.BLUE);
                g.drawLine(5, 30, 150, 40);
            }
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGui();
            }
        });
    }
}