import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.*;

public class Foo01 extends JPanel {
    private static final int PREF_W = 600;
    private static final int PREF_H = PREF_W;
    private static final Color COLOR_1 = Color.RED;
    private static final Color COLOR_2 = Color.BLUE;
    private static final int TIMER_DELAY = 100;
    private static final int RECT_X = 100;
    private static final int RECT_W = 400;
    private boolean blink = false;

    public Foo01() {
        setPreferredSize(new Dimension(PREF_W, PREF_H));
        new Timer(TIMER_DELAY, e -> {
            blink = !blink;
            repaint();
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (blink) {
            g.setColor(COLOR_1);
        } else {
            g.setColor(COLOR_2);
        }
        g.fillRect(RECT_X, RECT_X, RECT_W, RECT_W);
    }

    private static void createAndShowGui() {
        Foo01 mainPanel = new Foo01();

        JFrame frame = new JFrame("Foo01");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

}