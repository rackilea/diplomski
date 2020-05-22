import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class BalloonRectangle extends JPanel
{
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        Rectangle rectangle = new Rectangle(0, 0, 150, 50);

        Polygon triangle = new Polygon();
        triangle.addPoint(0, 0);
        triangle.addPoint(10, 5);
        triangle.addPoint(0, 10);
        triangle.translate(150, 10);

        Area balloon = new Area( rectangle );
        balloon.add( new Area( triangle ) );

        g2d.translate(50, 50);
        g2d.setColor( Color.YELLOW );
        g2d.fill( balloon );
        g2d.setColor( Color.GRAY );
        g2d.draw( balloon );

        g2d.dispose();
     }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("BalloonRectangle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new BalloonRectangle() );
        frame.setLocationByPlatform( true );
        frame.setSize(250, 200);
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
    }
}