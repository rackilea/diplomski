import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class BresenhamPoints extends JPanel {

    private static final int D_W = 500;
    private static final int D_H = 500;

    private List<Point> bresenhamList;
    private List<Point> paintList;

    public BresenhamPoints() {
        bresenhamList = createRandomPoints();
        paintList = new ArrayList<>();

        Timer timer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (bresenhamList.isEmpty()) {
                    ((Timer) e.getSource()).stop();
                } else {
                    paintList.add(bresenhamList.get(0));
                    bresenhamList.remove(0);
                }
                repaint();
            }
        });
        timer.start();
    }

    private List<Point> createRandomPoints() {
        Random rand = new Random();
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new Point(rand.nextInt(D_H), rand.nextInt(D_H)));
        }
        return list;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Point p : paintList) {
            g.fillOval(p.x - 5, p.y - 5, 10, 10);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(D_W, D_H);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new BresenhamPoints());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}