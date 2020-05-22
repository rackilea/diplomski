import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Football {

    public static void main(String[] args) {
        new Football();
    }

    public Football() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Football");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new FootballPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static class FootballPane extends JPanel {

        public static final int WINDOW_WIDTH = 800;
        public static final int WINDOW_HEIGHT = 400;

        private int x = 40;                // Ball's X coordinate
        private int y = 300;               // Ball's Y coordinate
        private static final int WIDTH = 35;      // Ball's width
        private static final int HEIGHT = 60;     // Ball's height

        private static final int X_MOVE = 14;     // Pixels to move ball
        private static final int Y_MOVE = 4;

        private static  final int TIME_DELAY = 25; // Time delay
        private Timer timer;               // Timer object

        /**
         * init method
         */
        public FootballPane() {

            // Set Background to a Dark Green
            setBackground(new Color(0, 220, 50));

            // initTimer();
            addMouseListener(new FbMouseListener());

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);
        }

        @Override
        protected void paintComponent(Graphics g) {
            // Call the superclass paint method.
            super.paintComponent(g); 

            // Set the color to Brown
            g.setColor(new Color(129, 74, 25));

            // Draw the football
            g.fillOval(x, y, WIDTH, HEIGHT);

            // Draw the Goalpost
            g.setColor(Color.YELLOW);
            g.fillRect(670, 240, 5, 140);
            g.fillRect(610, 80, 5, 140);
            g.fillRect(740, 120, 5, 140);
            // Need Thicker line
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(5));
            g2.drawLine(612, 220, 742, 260);
        }

        private class TimerListener implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                // Update the ball's position
                y -= Y_MOVE;
                x += X_MOVE;

                // Force a call to the paint method
                repaint();
            }

        }

        public void initTimer() {
            timer = new Timer(TIME_DELAY, new TimerListener());
            timer.start();
        }

        private class FbMouseListener implements MouseListener {

            public void mouseClicked(MouseEvent e) {
                if (e.getX() >= x && e.getX() <= (x + WIDTH) && e.getY() >= y && e.getY() <= (y + HEIGHT)) {
                    initTimer();
                }
            }

            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        }

    }

}