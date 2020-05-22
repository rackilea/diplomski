import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ShakeAnimation {

    public static void main(String[] args) {
        new ShakeAnimation();
    }

    public ShakeAnimation() {
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
                frame.add(new ShakePane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class ShakePane extends JPanel {

        private Timer timer;
        private LocalTime startTime;
        private int xOffset = 0;
        private int delta = 8;

        private BufferedImage img;

        public ShakePane() {
            try {
                img = ImageIO.read(getClass().getResource("Duke-Thumbs.jpg"));
            } catch (IOException exp) {
                exp.printStackTrace();
            }
            timer = new Timer(16, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Duration duration = Duration.between(startTime, LocalTime.now());
                    if (duration.getSeconds() >= 1) {
                        timer.stop();
                        xOffset = 0;
                    } else {
                        xOffset *= -1;
                    }
                    repaint();
                }
            });
            addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    if (!timer.isRunning()) {
                        xOffset = delta;
                        startTime = LocalTime.now();
                        timer.start();
                    }
                }

            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (img != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                int x = ((getWidth() - img.getWidth()) / 2) + xOffset;
                int y = (getHeight() - img.getHeight()) / 2;
                g2d.drawImage(img, x, y, this);
                g2d.dispose();
            }
        }

    }

}