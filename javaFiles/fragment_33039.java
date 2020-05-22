import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;
import java.awt.event.*;

import java.util.*;
import javax.swing.*;

public class Kimp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Kimp!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.add(new CanvasPanel());
        frame.setVisible(true);
    }
}

class CanvasPanel extends JPanel {
    private final List<List<Point>> lines = new LinkedList<List<Point>>();
    private List<Point> points = new LinkedList<Point>();

    public CanvasPanel() {
        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        for (List<Point> line : lines)
            drawLine(line, g);
        drawLine(points, g);
    }

    private void drawLine(List<Point> points, Graphics g) {
        if (points.size() < 2) return;

        Point p1 = points.get(0);

        for (int i=1, n=points.size(); i<n; i++) {
            Point p2 = points.get(i);

            g.setColor(Color.BLUE);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);

            p1 = p2;
        }
    }

    private MouseAdapter mouseAdapter = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            points.add(e.getPoint());
            repaint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            points.add(e.getPoint());
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (points.size() > 1) {
                lines.add(points);
                points = new LinkedList<Point>();
            }
        }
    };
}