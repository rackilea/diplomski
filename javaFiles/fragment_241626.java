import java.awt.event.KeyAdapter;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import static java.awt.Color.*;

/** @see http://stackoverflow.com/questions/2114455 */
public class GUI extends JPanel implements ActionListener {

    int x, y, x1, y1, x2, y2, changeY, changeY2;
    int changeX = 1; int changeX2 = 1;
    Timer t = new Timer(100, this);

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new GUI(true).display();
            }
        });
    }

    public GUI(boolean doubleBuffered) {
        super(doubleBuffered);
        this.setPreferredSize(new Dimension(320, 240));
    }

    private void display() {
        JFrame frame = new JFrame("GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(new KeyListener());
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        t.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(BLACK);
        g.fillRect(x, y, 100, 100);
        g.setColor(RED);
        g.fillRect(x1, y1, 50, 50);
        g.setColor(BLUE);
        g.fillRect(x2, y2, 25, 25);
    }

    public void change() {
        if (x1 >= x + 50 && changeY == 0 && changeX == 1) {
            changeX = 0;
            changeY = 1;
        } else if (y1 >= y + 50 && changeX == 0 && changeY == 1) {
            changeX = -1;
            changeY = 0;
        } else if (x1 <= x && changeX == -1 && changeY == 0) {
            changeX = 0;
            changeY = -1;
        } else if (y1 <= y && changeY == -1 && changeX == 0) {
            changeX = 1;
            changeY = 0;
        }
        x1 += changeX * 5;
        y1 += changeY * 5;
    }

    public void change2() {
        if (x2 >= x1 + 25 && changeY2 == 0 && changeX2 == 1) {
            changeX2 = 0;
            changeY2 = 1;
        } else if (y2 >= y1 + 25 && changeX2 == 0 && changeY2 == 1) {
            changeX2 = -1;
            changeY2 = 0;
        } else if (x2 <= x1 && changeX2 == -1 && changeY2 == 0) {
            changeX2 = 0;
            changeY2 = -1;
        } else if (y2 <= y1 && changeY2 == -1 && changeX2 == 0) {
            changeX2 = 1;
            changeY2 = 0;
        }
        x2 += changeX2 * 2;
        y2 += changeY2 * 2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        change();
        change2();
        repaint();
    }

    private class KeyListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            int d = 5;
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                if (y - d >= 0) {
                    y -= d;
                    y1 -= d;
                    y2 -= d;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                if (y + 100 + d <= getHeight()) {
                    y += d;
                    y1 += d;
                    y2 += d;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (x - d >= 0) {
                    x -= d;
                    x1 -= d;
                    x2 -= d;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (x + 100 + d <= getWidth()) {
                    x += d;
                    x1 += d;
                    x2 += d;
                }
            }
        }
    }
}