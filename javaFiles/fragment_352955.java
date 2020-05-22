import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PathFollowerTest
{
    public static void main(String[] args)
    {
        final PathFollower pathFollower = createPathFollowerY();
        //final PathFollower pathFollower = createPathFollowerX();

        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                createAndShowGUI(pathFollower);
            }
        });
    }

    private static PathFollower createPathFollowerY()
    {
        Point2D p0 = new Point2D.Double(225, 300);
        Point2D p1 = new Point2D.Double(225, 225);
        Point2D p2 = new Point2D.Double(150, 150);
        Point2D p3 = new Point2D.Double(300, 150);
        PathFollower pathFollower = new PathFollower();
        pathFollower.addPoint(p0);
        pathFollower.addPoint(p1);
        pathFollower.addPoint(p2);
        pathFollower.addPoint(p1);
        pathFollower.addPoint(p3);
        pathFollower.addPoint(p1);
        pathFollower.addPoint(p0);
        return pathFollower;
    }

    private static PathFollower createPathFollowerX()
    {
        Point2D p0 = new Point2D.Double(150, 300);
        Point2D p1 = new Point2D.Double(225, 225);
        Point2D p2 = new Point2D.Double(150, 150);
        Point2D p3 = new Point2D.Double(300, 300);
        Point2D p4 = new Point2D.Double(300, 150);
        PathFollower pathFollower = new PathFollower();
        pathFollower.addPoint(p0);
        pathFollower.addPoint(p1);
        pathFollower.addPoint(p2);
        pathFollower.addPoint(p1);
        pathFollower.addPoint(p4);
        pathFollower.addPoint(p1);
        pathFollower.addPoint(p3);
        pathFollower.addPoint(p1);
        pathFollower.addPoint(p0);
        return pathFollower;
    }

    private static void createAndShowGUI(final PathFollower pathFollower)
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(100, 100, 550, 550);
        f.getContentPane().setLayout(new BorderLayout());

        PathFollowerPanel pathFollowerPanel = 
            new PathFollowerPanel(pathFollower);
        f.getContentPane().add(pathFollowerPanel, BorderLayout.CENTER);

        final PathFollowerController pathFollowerController = 
            new PathFollowerController(
                pathFollower, pathFollowerPanel);

        JPanel panel = new JPanel();
        f.getContentPane().add(panel, BorderLayout.SOUTH);
        final JCheckBox cb = new JCheckBox("Animacja");
        cb.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                pathFollowerController.setRunning(cb.isSelected());
            }
        });
        panel.add(cb);

        final JSlider speedSlider = new JSlider(-30, 30, 0);
        panel.add(speedSlider);
        speedSlider.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                pathFollowerController.setSpeed(speedSlider.getValue());
            }
        });
        f.setLocationRelativeTo(null);
        f.setVisible(true);

    }
}

class PathFollowerController
{
    private int speed = 0;
    private PathFollower pathFollower;
    private PathFollowerPanel pathFollowerPanel;

    private final Timer timer = new Timer(50, new ActionListener()
    {
        private double alpha = 0;

        @Override
        public void actionPerformed(ActionEvent e)
        {
            alpha += speed / 500.0;
            alpha %= 1.0;
            while (alpha < -1.0)
            {
                alpha += 1.0;
            }
            pathFollower.setAlpha(alpha < 0 ? -alpha : alpha);
            pathFollowerPanel.repaint();
        }
    });

    PathFollowerController(PathFollower pathFollower,
        PathFollowerPanel pathFollowerPanel)
    {
        this.pathFollower = pathFollower;
        this.pathFollowerPanel = pathFollowerPanel;
    }

    void setRunning(boolean running)
    {
        if (running)
        {
            timer.start();
        }
        else
        {
            timer.stop();
        }
    }

    public void setSpeed(int speed)
    {
        this.speed = speed;
    }
}

class PathFollower
{
    private final List<Point2D> points;
    private Shape path;
    private double pathLength = -1;
    private double alpha = 0;

    PathFollower()
    {
        points = new ArrayList<Point2D>();
    }

    void addPoint(Point2D p)
    {
        points.add(new Point2D.Double(p.getX(), p.getY()));
        path = null;
        pathLength = -1;
    }

    void setAlpha(double alpha)
    {
        this.alpha = alpha;
    }

    Point2D getCurrentPoint()
    {
        return computePoint(alpha);
    }

    Shape getPath()
    {
        if (path == null)
        {
            path = createPath();
        }
        return path;
    }

    private Shape createPath()
    {
        Path2D path = new Path2D.Double();
        for (int i = 0; i < points.size(); i++)
        {
            Point2D p = points.get(i);
            double x = p.getX();
            double y = p.getY();
            if (i == 0)
            {
                path.moveTo(x, y);
            }
            else
            {
                path.lineTo(x, y);
            }
        }
        return path;
    }

    private double computePathLength()
    {
        double pathLength = 0;
        for (int i = 0; i < points.size() - 1; i++)
        {
            Point2D p0 = points.get(i);
            Point2D p1 = points.get(i + 1);
            pathLength += p0.distance(p1);
        }
        return pathLength;
    }

    private Point2D computePoint(double alpha)
    {
        if (pathLength < 0)
        {
            pathLength = computePathLength();
        }
        double alphaPosition = alpha * pathLength;
        double accumulatedLength = 0;
        for (int i = 0; i < points.size() - 1; i++)
        {
            Point2D p0 = points.get(i);
            Point2D p1 = points.get(i + 1);
            double distance = p0.distance(p1);
            double nextLength = accumulatedLength + distance;
            if (nextLength >= alphaPosition)
            {
                double localAlpha = 
                    (alphaPosition - accumulatedLength) / distance;
                double x = p0.getX() + localAlpha * (p1.getX() - p0.getX());
                double y = p0.getY() + localAlpha * (p1.getY() - p0.getY());
                return new Point2D.Double(x, y);
            }
            accumulatedLength = nextLength;
        }
        Point2D p = points.get(points.size() - 1);
        return new Point2D.Double(p.getX(), p.getY());
    }

}

class PathFollowerPanel extends JPanel
{
    private final PathFollower pathFollower;

    PathFollowerPanel(PathFollower pathFollower)
    {
        this.pathFollower = pathFollower;
    }

    @Override
    protected void paintComponent(Graphics gr)
    {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D) gr;
        g.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(Color.BLUE);
        g.setStroke(new BasicStroke(3.0f));
        g.draw(pathFollower.getPath());

        g.setColor(Color.RED);
        Point2D p = pathFollower.getCurrentPoint();
        double r = 5;
        g.fill(new Ellipse2D.Double(
            p.getX() - r, p.getY() - r, r + r, r + r));
    }
}