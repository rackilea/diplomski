import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FollowMe {

    public static void main(String[] args) {
        new FollowMe();
    }

    public FollowMe() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private Point targetPoint;
        private BufferedImage turret;
        private BufferedImage base;

        public TestPane() {
            addMouseMotionListener(new MouseAdapter() {

                @Override
                public void mouseMoved(MouseEvent e) {
                    targetPoint = e.getPoint();
                    repaint();
                }

            });
            try {
                base = ImageIO.read(getClass().getResource("/Base.png"));
                turret = ImageIO.read(getClass().getResource("/Turret.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
            g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
            if (base != null) {
                double x = (getWidth() - base.getWidth()) / 2d;
                double y = (getHeight() - base.getHeight()) / 2d;
                // Test line from center of tank to mouse poisition
                if (targetPoint != null) {
                    g2d.draw(new Line2D.Double((x + 12), (y + 12), targetPoint.x, targetPoint.y));
                }
                AffineTransform at = AffineTransform.getTranslateInstance(x, y);
                g2d.setTransform(at);
                g2d.drawImage(base, 0, 0, this);
                at.translate(8, 8);
                if (targetPoint != null) {
                    double deltaX = (x + 8) - targetPoint.x;
                    double deltaY = (y + 8) - targetPoint.y;

                    double rotation = Math.atan2(deltaY, deltaX) + Math.toRadians(180d);
                    at.rotate(rotation, 4, 4);
                }
                g2d.setTransform(at);
                g2d.drawImage(turret, 0, 0, this);
            }
            g2d.dispose();
        }

    }

}