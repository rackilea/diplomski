import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CircleProgress {

    public static void main(String[] args) {
        new CircleProgress();
    }

    public CircleProgress() {
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
                frame.add(new ProgressPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class ProgressPane extends JPanel {

        private float progress;
        private float startAt = 270;
        private float direction = -1;
        private Timer timer;

        public ProgressPane() {
            timer = new Timer(80, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    float value = getProgress();
                    if (value >= 1f) {
                        timer.stop();
                    }
                    setProgress(value += 0.01);
                }
            });
        }

        public void setProgress(float progress) {
            if (progress < 0.0) {
                progress = 0;
            } else if (progress > 1f) {
                progress = 1f;
            }
            this.progress = progress;
            repaint();
        }

        public float getProgress() {
            return progress;
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(100, 100);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            float extent = (360f * getProgress()) * direction;
            int width = getWidth();
            int height = getHeight();
            int radius = Math.min(width, height);

            int x = (width - radius) / 2;
            int y = (height - radius) / 2;

            g2d.setColor(Color.YELLOW);
            Arc2D arc = new Arc2D.Double(x, y, radius, radius, startAt, extent, Arc2D.PIE);
            g2d.fill(arc);

            g2d.dispose();
        }
    }

}