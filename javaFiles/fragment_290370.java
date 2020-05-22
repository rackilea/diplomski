import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Path2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ShapeOutlineTest
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI()
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.getContentPane().add(new ShapeOutlineTestPanel());
        f.setSize(500, 500);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}

class ShapeOutlineTestPanel extends JPanel
{
    @Override
    protected void paintComponent(Graphics gr)
    {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D) gr;

        int[] xs = { 25, 125, 85, 75, 25, 65, };
        int[] ys = { 50, 50, 100, 110, 150, 100 };

        BasicStroke traceStroke = new BasicStroke(1);
        g.setStroke(traceStroke);
        g.setColor(Color.BLUE);
        g.drawPolyline(xs, ys, 6);

        Path2D path = new Path2D.Double();
        for (int i = 0; i < xs.length; i++)
        {
            if (i == 0)
            {
                path.moveTo(xs[i], ys[i]);
            }
            else
            {
                path.lineTo(xs[i], ys[i]);
            }
        }
        g.setColor(Color.RED);
        BasicStroke stroke = new BasicStroke(
            10.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        g.draw(new Area(stroke.createStrokedShape(path)));

    }
}