import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Test");
                frame.add(new AnimationComponent(0, 0, 50, 50));
                frame.setSize(300, 300);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class AnimationComponent extends JComponent implements ActionListener {

        private Timer animTimer;
        private int x;
        private int y;
        private int xVel;
        private int yVel;
        private int width;
        private int height;
        private int oldX;
        private int oldY;

        public AnimationComponent(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
            this.width = width;

            animTimer = new Timer(5, this);
            xVel = 1;
            yVel = 1;

            animTimer.start();
        }

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON
            );
            g2d.setRenderingHints(hints);
            g2d.fillOval(x, y, width, height);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            oldX = x;
            oldY = y;

            if (x + width > getParent().getWidth() || x < 0) {
                xVel *= -1;
            }

            if (y + height > getParent().getHeight() || y < 0) {
                yVel *= -1;
            }

            x += xVel;
            y += yVel;

            repaint();
        }
    }
}