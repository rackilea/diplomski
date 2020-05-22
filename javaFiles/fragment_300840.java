import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class LinesAtCirclesTest
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {

            @Override
            public void run()
            {
                createAndShowGUI();
            }
        });
    }
    private static void createAndShowGUI()
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel linesAtCirclesTestPanel = new LinesAtCirclesTestPanel(); 
        f.getContentPane().add(linesAtCirclesTestPanel);
        f.setSize(400,400);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}

class LinesAtCirclesTestPanel extends JPanel 
    implements MouseListener, MouseMotionListener
{
    private Point2D draggedCenter;
    private List<Point2D> centers = new ArrayList<Point2D>();
    private List<Double> radii = new ArrayList<Double>();

    public LinesAtCirclesTestPanel()
    {
        addMouseListener(this);
        addMouseMotionListener(this);

        addCircle(100, 100, 30);
        addCircle(200, 300, 50);
        addCircle(300, 200, 40);
    }

    private void addCircle(double x, double y, double radius)
    {
        centers.add(new Point2D.Double(x,y));
        radii.add(radius);
    }

    @Override
    protected void paintComponent(Graphics gr)
    {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D)gr;
        g.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING, 
            RenderingHints.VALUE_ANTIALIAS_ON);

        for (int i=0; i<centers.size(); i++)
        {
            Point2D center0 = centers.get(i);
            double radius0 = radii.get(i);

            Shape ellipse = new Ellipse2D.Double(
                center0.getX() - radius0, center0.getY() - radius0, 
                radius0 + radius0, radius0 + radius0);

            g.setColor(Color.LIGHT_GRAY);
            g.fill(ellipse);
            g.setColor(Color.BLACK);
            g.draw(ellipse);
        }

        g.setColor(Color.RED);
        for (int i=0; i<centers.size() - 1; i++)
        {
            Point2D center0 = centers.get(i);
            double radius0 = radii.get(i);
            Point2D center1 = centers.get(i+1);
            double radius1 = radii.get(i+1);

            g.draw(createArrow(computeLine(center0, radius0, center1, radius1, true)));
            g.draw(createArrow(computeLine(center0, radius0, center1, radius1, false)));
        }
    }

    private static Shape createArrow(Line2D line)
    {
        double dx = line.getX2() - line.getX1();
        double dy = line.getY2() - line.getY1();
        double angleToX = Math.atan2(dy, dx);
        final double angleRad = Math.toRadians(30);
        final double headLength = 20.0f;
        double dxL = Math.cos(Math.PI + angleToX + angleRad) * headLength;
        double dyL = Math.sin(Math.PI + angleToX + angleRad) * headLength;
        double dxR = Math.cos(Math.PI + angleToX - angleRad) * headLength;
        double dyR = Math.sin(Math.PI + angleToX - angleRad) * headLength;
        Path2D arrow = new Path2D.Double();
        arrow.moveTo(line.getX1(), line.getY1());
        arrow.lineTo(line.getX2(), line.getY2());
        arrow.lineTo(line.getX2() + dxL, line.getY2() + dyL);
        arrow.moveTo(line.getX2(), line.getY2());
        arrow.lineTo(line.getX2() + dxR, line.getY2() + dyR);
        return arrow;
    }

    private static Line2D computeLine(
        Point2D center0, double radius0,
        Point2D center1, double radius1, 
        boolean upper)
    {
        double dx = center1.getX() - center0.getX();
        double dy = center1.getY() - center0.getY();
        double invLength = 1.0 / Math.hypot(dx, dy);
        double dirX = dx * invLength;
        double dirY = dy * invLength;

        double rotDirX = dirY;
        double rotDirY = -dirX;
        if (upper)
        {
            rotDirX = -dirY;
            rotDirY = dirX;
        }

        double x0 = center0.getX() + rotDirX * radius0;
        double y0 = center0.getY() + rotDirY * radius0;

        double x1 = center1.getX() + rotDirX * radius1;
        double y1 = center1.getY() + rotDirY * radius1;

        if (upper)
        {
            return new Line2D.Double(x1, y1, x0, y0);
        }
        return new Line2D.Double(x0, y0, x1, y1);
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        draggedCenter = null;
        for (int i=0; i<centers.size(); i++)
        {
            Point2D center = centers.get(i);
            double radius = radii.get(i);
            if (e.getPoint().distance(center) < radius)
            {
                draggedCenter = center;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        draggedCenter = null;
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        if (draggedCenter == null)
        {
            return;
        }
        draggedCenter.setLocation(e.getPoint());
        repaint();
    }



    @Override
    public void mouseMoved(MouseEvent e)
    {
        // Not used
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        // Not used
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        // Not used
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        // Not used
    }
}