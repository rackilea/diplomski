import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

class DrawingPanel extends JPanel
{
    private ArrayList<ArrayList<Point>> previous = new ArrayList<ArrayList<Point>>();
    private ArrayList<Point> current = new ArrayList<Point>();
    private BasicStroke basicStroke;

    public DrawingPanel(int strokeSize)
    {
        basicStroke = new BasicStroke(strokeSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

        MouseAdapter ma = new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                current.add( new Point(e.getX(), e.getY()) );
            }

            @Override
            public void mouseDragged(MouseEvent e)
            {
                current.add( new Point(e.getX(), e.getY()) );
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                if (current.size() > 1)
                {
                    previous.add( current );
                }

                current = new ArrayList<Point>();
            }
        };

        addMouseMotionListener( ma );
        addMouseListener( ma );
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke( basicStroke );

        //  Paint lines from previous drags

        for (int i = 0; i < previous.size(); i++)
        {
            drawLines(g, previous.get(i));
        }

        //  Paint line from current drag

        drawLines(g, current);
    }

    private void drawLines(Graphics g, ArrayList<Point> points)
    {
        for (int i = 0; i < points.size() - 1; i++)
        {
            int x = (int) points.get(i).getX();
            int y = (int) points.get(i).getY();
            int x2 = (int) points.get(i + 1).getX();
            int y2 = (int) points.get(i + 1).getY();
            g.drawLine(x, y, x2, y2);
        }
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("Drawing Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new DrawingPanel(15));
        frame.setSize(400, 400);
        frame.setLocationByPlatform( true );
        frame.setVisible( true );
    }

    public static void main(String[] args) throws Exception
    {
        EventQueue.invokeLater( () -> createAndShowGUI() );
/*
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
*/
    }
}