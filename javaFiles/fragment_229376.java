import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Broadway extends JPanel {

    int locx, locy; // location of rectangle
    int width, height; // dimensions of rectangle
    Timer timer;
// direction of motion
    static final byte UP = 0;
    static final byte DOWN = 1;
    static final byte LEFT = 2;
    static final byte RIGHT = 3;
    byte state; // state the rect is in
// length of pausing interval in ms
    static final int REFRESH_RATE = 100;

    public Broadway() {

        setBackground(Color.black);

        locx = 80; // parameters of center rect
        locy = 100;
        width = 110;
        height = 90;
        state = UP;

        ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                updateRectangle();
            }
        };

        timer = new Timer(this.REFRESH_RATE, listener);
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.yellow);
        g.fillRect(0, 0, 90, 90);
        g.fillRect(250, 0, 40, 190);
        g.fillRect(80, 110, 100, 20);

        g.setColor(Color.blue);
        g.fillRect(80, 200, 220, 90);
        g.fillRect(100, 10, 90, 80);

        g.setColor(Color.lightGray);
        g.fillRect(locx, locy, width, height);

        g.setColor(Color.red);
        g.fillRect(200, 0, 45, 45);
        g.fillRect(0, 100, 70, 200);

        g.setColor(Color.magenta);
        g.fillRect(200, 55, 60, 135);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }

//update the center rectangle
    void updateRectangle() {

        switch (state) {
            case DOWN:
                locy += 2;
                if (locy >= 110) {
                    state = UP;
                }
                break;
            case UP:
                locy -= 2;
                if (locy <= 90) {
                    state = RIGHT;
                }
                break;
            case RIGHT:
                locx += 2;
                if (locx >= 90) {
                    state = LEFT;
                }
                break;
            case LEFT:
                locx -= 2;
                if (locx <= 70) {
                    state = DOWN;
                }
                break;
        }
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                Broadway bw  = new Broadway();

                bw.start();
                JOptionPane.showMessageDialog(null, bw);
                bw.stop();
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
        SwingUtilities.invokeLater(r);
    }
}