import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SimpleSprite {

    public static void main(String[] args) {
        new SimpleSprite();
    }

    public SimpleSprite() {
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
                frame.add(new AnimationPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class AnimationPane extends JPanel {

        private BufferedImage dalek;
        private Point dalekPoint;
        private int deltaX = 1;

        public AnimationPane() {
            dalekPoint = new Point();
            try {
                dalek = ImageIO.read(getClass().getResource("/dalek.png"));
                dalekPoint.y = (200 - dalek.getHeight()) / 2;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (dalekPoint.x + dalek.getWidth() > getWidth()) {
                        dalekPoint.x = getWidth() - dalek.getWidth();
                        deltaX *= -1;
                    } else if (dalekPoint.x < 0) {
                        dalekPoint.x = 0;
                        deltaX *= -1;
                    } else {
                        dalekPoint.x += deltaX;
                    }
                    repaint();
                }
            });
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.drawImage(dalek, dalekPoint.x, dalekPoint.y, this);
            g2d.dispose();
        }
    }

}