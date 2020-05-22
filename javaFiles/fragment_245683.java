import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class RingPaintTest
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
        RingPaintTestPanel p = new RingPaintTestPanel();
        f.getContentPane().add(p);
        f.setSize(800,800);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}


class RingPaintTestPanel extends JPanel
{
    @Override
    protected void paintComponent(Graphics gr)
    {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D)gr;

        g.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(Color.RED);
        g.drawString("Text", 100, 100);
        g.drawString("Text", 300, 100);

        Shape ring = createRingShape(100, 100, 80, 20); 
        g.setColor(Color.CYAN);
        g.fill(ring);
        g.setColor(Color.BLACK);
        g.draw(ring);

        Shape otherRing = createRingShape(300, 100, 80, 20); 
        g.setPaint(new GradientPaint(
            new Point(250, 40), Color.RED, 
            new Point(350, 200), Color.GREEN));
        g.fill(otherRing);
        g.setColor(Color.BLACK);
        g.draw(otherRing);

    }

    private static Shape createRingShape(
        double centerX, double centerY, double outerRadius, double thickness)
    {
        Ellipse2D outer = new Ellipse2D.Double(
            centerX - outerRadius, 
            centerY - outerRadius,
            outerRadius + outerRadius, 
            outerRadius + outerRadius);
        Ellipse2D inner = new Ellipse2D.Double(
            centerX - outerRadius + thickness, 
            centerY - outerRadius + thickness,
            outerRadius + outerRadius - thickness - thickness, 
            outerRadius + outerRadius - thickness - thickness);
        Area area = new Area(outer);
        area.subtract(new Area(inner));
        return area;
    }

}