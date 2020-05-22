import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MyPokeBalls {

    public static void main(String[] args) {
        new MyPokeBalls();
    }

    public MyPokeBalls() {
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
                frame.add(new PokeBall());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class PokeBall extends JPanel {

        private BufferedImage balls;
        private int ballWidth = 70;
        private int ballHeight = 70;
        private int ballOffset = 0;

        public PokeBall() {
            try {
                balls = ImageIO.read(new File("PokeBalls.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            MouseAdapter ma = new MouseAdapter() {

                private boolean isIn = false;

                @Override
                public void mouseEntered(MouseEvent e) {
                    ballOffset = 1;
                    isIn = true;
                    repaint();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    ballOffset = 0;
                    isIn = true;
                    repaint();
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    ballOffset = 2;
                    repaint();
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    if (isIn) {
                        ballOffset = 1;
                    } else {
                        ballOffset = 2;
                    }
                    repaint();
                }

            };

            addMouseListener(ma);
            addMouseMotionListener(ma);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(ballWidth, ballHeight);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (balls != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                BufferedImage ball = balls.getSubimage(ballWidth * ballOffset, 0, ballWidth, ballHeight);
                int x = (getWidth() - ball.getWidth()) / 2;
                int y = (getHeight() - ball.getHeight()) / 2;
                g2d.drawImage(ball, x, y, this);
                g2d.dispose();
            }
        }
    }
}