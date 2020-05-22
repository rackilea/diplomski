import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class MoveBallTest extends JPanel{
    private static final int PREF_W = 1000;
    private static final int PREF_H = 600;
    private static final int TIMER_DELAY = 12;
    private static final int SPRITE_WIDTH = 30;
    private static final Color OVAL_SPRITE_COLOR = Color.RED;
    private static final Color RECT_SPRITE_COLOR = Color.BLUE;
    private static final int DELTAY_Y = 1;
    private boolean goingDown = true;
    private Timer timer = new Timer(TIMER_DELAY, this::timerActionPerformed);
    private int ovalSpriteY;
    private int rectSpriteY;

    public MoveBallTest() {
        timer.start();
        MyMouse myMouse = new MyMouse();
        addMouseMotionListener(myMouse);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(OVAL_SPRITE_COLOR);
        g.fillOval(SPRITE_WIDTH, ovalSpriteY, SPRITE_WIDTH, SPRITE_WIDTH);
        g.setColor(RECT_SPRITE_COLOR);
        g.fillRect(SPRITE_WIDTH, rectSpriteY, SPRITE_WIDTH / 2, SPRITE_WIDTH * 3);
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    public void timerActionPerformed(ActionEvent e) {
        if (ovalSpriteY <= 0) {
            goingDown = true;
        } else if (ovalSpriteY >= getHeight() - SPRITE_WIDTH) {
            goingDown = false;
        }

        ovalSpriteY += goingDown ? DELTAY_Y : -DELTAY_Y;
        repaint();
    }

    private class MyMouse extends MouseAdapter {
        @Override
        public void mouseMoved(MouseEvent e) {
            rectSpriteY = e.getY();
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("MoveBallTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MoveBallTest());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}