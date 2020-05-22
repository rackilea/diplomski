import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new RoulettePane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class RoulettePane extends JPanel {

        private double spinValue = 0;
        private Timer timer;

        public RoulettePane() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    spin();
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 300);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            paintRoulette(g2d);
            g2d.dispose();
        }

        protected void spin() {
            if (timer != null && timer.isRunning()) {
                return;
            }
            timer = new Timer(5, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    spinValue += 0.01;
                    repaint();
                }
            });
            timer.start();
        }

        protected void paintRoulette(Graphics2D g2d) {
            RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHints(hints);

            int width = getWidth();
            int height = getHeight();

            int dimeter = Math.min(width, height);

            AffineTransform at = AffineTransform.getRotateInstance(spinValue, dimeter / 2, dimeter / 2);
            g2d.transform(at);

            double angle = 360 / 36.9;
            double startAngle = 0;
            int color = 0;
            for (int i = 0; i < 37; i++) {
                if (i == 0) {
                    g2d.setColor(Color.GREEN);
                } else {
                    if (color == 0) {
                        g2d.setColor(Color.BLACK);
                        color = 1;
                    } else {
                        g2d.setColor(Color.RED);
                        color = 0;
                    }
                }

                g2d.fill(new Arc2D.Double(0, 0, dimeter, dimeter, startAngle, angle, Arc2D.PIE));
                startAngle += angle;
            }
        }
    }
}