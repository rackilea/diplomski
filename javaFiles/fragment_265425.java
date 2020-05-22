import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class DrawLineVsDrawPolyline
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
        JFrame f = new JFrame("");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setLayout(new BorderLayout());

        class Line
        {
            int x1, y1, x2, y2;
            Line(int x1, int y1, int x2, int y2)
            {
                this.x1 = x1;
                this.y1 = y1;
                this.x2 = x2;
                this.y2 = y2;
            }
            public int getX1Point()
            {
                return x1;
            }
            public int getY1Point()
            {
                return y1;
            }
            public int getX2Point()
            {
                return x2;
            }
            public int getY2Point()
            {
                return y2;
            }
        }
        int xPoints[] = new int[] { 100, 150, 200 };
        int yPoints[] = new int[] { 100, 250, 100 };
        int nPoints = xPoints.length;
        List<Line> lines = new ArrayList<Line>();
        for (int i0=0; i0<nPoints-1; i0++)
        {
            int i1 = i0+1;
            int x1 = xPoints[i0];
            int y1 = yPoints[i0];
            int x2 = xPoints[i1];
            int y2 = yPoints[i1];
            lines.add(new Line(x1,y1,x2,y2));
        }

        JPanel panel = new JPanel()
        {
            @Override
            protected void paintComponent(Graphics gr) 
            {
                super.paintComponent(gr);
                Graphics2D g = (Graphics2D)gr;

                g.setColor(Color.RED);
                g.setStroke(new BasicStroke(20.0f, 
                    BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND));

                g.drawPolyline(xPoints, yPoints, nPoints);

                g.translate(200, 0);

                for (Line line : lines) {
                    g.drawLine(
                        line.getX1Point(), line.getY1Point(), 
                        line.getX2Point(), line.getY2Point());     
                }

            }
        };
        f.getContentPane().add(panel, BorderLayout.CENTER);

        f.setSize(500,500);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

}