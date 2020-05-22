import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
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

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new HilbertCurveLineRenderer(model));
                frame.pack();
                frame.setLocation(100, 100);
                frame.setVisible(true);

                JFrame frame2 = new JFrame();
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.add(new HilbertCurveLineAndPointRenderer(model));
                frame2.pack();
                frame2.setLocation(100 + frame.getWidth(), 100);
                frame2.setVisible(true);
            }
        });
    }

    public abstract class AbstractHilbertCurve extends JPanel {

        private HilbertCurveModel model;

        public AbstractHilbertCurve(HilbertCurveModel model) {
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
            int count = 0;
            for (Point to : points) {
                count++;
                // I don't trust you to play nice with my graphics context
                Graphics2D copyG = (Graphics2D) g2d.create();
                renderLine(copyG, from, to);
                renderCurrentPoint(copyG, count, to);
                from = to;
                copyG.dispose();
            }
            g2d.dispose();
        }

        protected void renderLine(Graphics2D g2d, Point from, Point to) {
        }

        protected void renderCurrentPoint(Graphics2D g2d, int count, Point current) {
        }
    }

    public class HilbertCurveLineRenderer extends AbstractHilbertCurve {

        public HilbertCurveLineRenderer(HilbertCurveModel model) {
            super(model);
        }

        protected void renderLine(Graphics2D g2d, Point from, Point to) {
            Line2D line = new Line2D.Double(from, to);
            g2d.draw(line);
        }
    }

    public class HilbertCurveLineAndPointRenderer extends AbstractHilbertCurve {

        public HilbertCurveLineAndPointRenderer(HilbertCurveModel model) {
            super(model);
        }

        protected void renderLine(Graphics2D g2d, Point from, Point to) {
            Line2D line = new Line2D.Double(from, to);
            g2d.draw(line);
        }

        @Override
        protected void renderCurrentPoint(Graphics2D g2d, int count, Point current) {
            String text = Integer.toString(count);
            FontMetrics fm = g2d.getFontMetrics();
            int x = current.x - (fm.stringWidth(text) / 2); 
            g2d.drawString(text, x, current.y);
        }

    }
}