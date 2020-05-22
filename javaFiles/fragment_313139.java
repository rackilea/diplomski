import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
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
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private List<Line> lines;

        public TestPane() {
            lines = new ArrayList<Line>(25);
            MouseAdapter ma = new MouseAdapter() {

                private Line currentLine;

                @Override
                public void mousePressed(MouseEvent e) {
                    currentLine = new Line(e.getPoint());
                    Collections.sort(lines);
                    lines.add(currentLine);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    currentLine = null;
                    repaint();
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    currentLine.to(e.getPoint());
                    Collections.sort(lines);
                    repaint();
                }

            };
            addMouseListener(ma);
            addMouseMotionListener(ma);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            if (!lines.isEmpty()) {
                Line shortest = lines.get(0);
                Line longest = lines.get(lines.size() - 1);
                if (lines.size() > 2) {
                    lines.subList(1, lines.size() - 2);
                    for (Line line : lines) {
                        g2d.draw(line.getShape());
                    }
                }

                g2d.setColor(Color.RED);
                g2d.draw(shortest.getShape());
                if (!longest.equals(shortest)) {
                    g2d.setColor(Color.GREEN);
                    g2d.draw(longest.getShape());
                }
            }
            g2d.dispose();
        }

    }

    public class Line implements Comparable<Line> {

        private Point p1;
        private Point p2;

        public Line(Point p1) {
            this.p1 = p1;
            this.p2 = p1;
        }

        public Line to(Point p) {
            p2 = p;
            return this;
        }

        public double getLength() {
            return Math.sqrt(((p2.x - p1.x) * (p2.x - p1.x)) + ((p2.y - p1.y) * (p2.y - p1.y)));
        }

        @Override
        public int compareTo(Line o) {
            return (int) (getLength() - o.getLength());
        }

        public Line2D getShape() {
            return new Line2D.Double(p1, p2);
        }

    }

}