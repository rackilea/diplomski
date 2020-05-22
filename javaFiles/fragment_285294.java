import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class Test {

    public class HilbertCurveModel {

        private List<Point> points;
        private int distribution;

        private int xDelta, yDelta;

        public HilbertCurveModel(int level, int size) {
            points = new ArrayList<>(25);
            distribution = size;
            for (int i = level; i > 0; i--) {
                distribution /= 2;
            }
            hilbertU(level);
        }

        public int getDistribution() {
            return distribution;
        }

        public List<Point> getPoints() {
            List<Point> copy = new ArrayList<>(points.size());
            for (Point p : points) {
                copy.add(new Point(p));
            }
            return copy;
        }

        protected void addLine(int x, int y) {
            points.add(new Point(x + xDelta, y + yDelta));
            xDelta += x;
            yDelta += y;
        }

        private void hilbertU(int level) {
            if (level > 0) {
                hilbertD(level - 1);
                addLine(0, distribution);
                hilbertU(level - 1);
                addLine(distribution, 0);
                hilbertU(level - 1);
                addLine(0, -distribution);
                hilbertC(level - 1);
            }
        }

        private void hilbertD(int level) {
            if (level > 0) {
                hilbertU(level - 1);
                addLine(distribution, 0);
                hilbertD(level - 1);
                addLine(0, distribution);
                hilbertD(level - 1);
                addLine(-distribution, 0);
                hilbertA(level - 1);
            }
        }

        private void hilbertC(int level) {
            if (level > 0) {
                hilbertA(level - 1);
                addLine(-distribution, 0);
                hilbertC(level - 1);
                addLine(0, -distribution);
                hilbertC(level - 1);
                addLine(distribution, 0);
                hilbertU(level - 1);
            }
        }

        private void hilbertA(int level) {
            if (level > 0) {
                hilbertC(level - 1);
                addLine(0, -distribution);
                hilbertA(level - 1);
                addLine(-distribution, 0);
                hilbertA(level - 1);
                addLine(0, distribution);
                hilbertD(level - 1);
            }
        }

    }

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                HilbertCurveModel model = new HilbertCurveModel(4, 512);

                HilbertCurve exemplo1 = new HilbertCurve(model);
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(exemplo1);
                frame.pack();
                frame.setLocation(100, 100);
                frame.setVisible(true);

                // This is the second window ;)

                int xPos = model.getDistribution() / 2;
                int yPos = model.getDistribution() / 2;

                DefaultListModel listModel = new DefaultListModel();
                listModel.addElement(new Point(xPos, yPos));
                for (Point p : model.getPoints()) {
                    listModel.addElement(p);
                }

                JFrame frame1 = new JFrame();
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.add(new JScrollPane(new JList(listModel)));
                frame1.pack();
                frame1.setLocation(800, 100);
                frame1.setVisible(true);
            }
        });
    }

    public class HilbertCurve extends JPanel {

        private HilbertCurveModel model;
        private int xPos, yPos;

        public HilbertCurve(HilbertCurveModel model) {
            this.model = model;
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(520, 520);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int xPos = model.getDistribution() / 2;
            int yPos = model.getDistribution() / 2;

            List<Point> points = model.points;
            if (points.size() == 0) {
                return;
            }
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.translate(xPos, yPos);
            g2d.setColor(Color.BLACK);
            Point from = new Point(0, 0);
            for (Point point : points) {
                Point to = new Point(point);
                System.out.println(from + "x" + to);
                Line2D line = new Line2D.Double(from, to);
                g2d.draw(line);
                from = to;
            }
            g2d.dispose();
        }
    }
}