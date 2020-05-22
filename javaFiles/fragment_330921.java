import javax.swing.*;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;

public class DrawTest extends JPanel
{
    String text;

    public DrawTest(String text)
    {
        this.text = text;
//      setFont( new Font("Arial", Font.PLAIN, 24) );
        setFont( new Font("Monospaced", Font.PLAIN, 24) );
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setFont( getFont() );
        g2d.setPaint(Color.RED);

        //  Draw text using FontMetrics

        FontMetrics fm = g2d.getFontMetrics();
        Rectangle2D rect = fm.getStringBounds(text, g2d);
        rect.setRect(rect.getX() + 100, rect.getY() + 50, rect.getWidth(), rect.getHeight());
        g2d.draw(rect);

        //  Draw text using TextLayout

        g2d.setPaint(Color.BLACK);

        Point2D loc = new Point2D.Float(100, 50);
        FontRenderContext frc = g2d.getFontRenderContext();
        TextLayout layout = new TextLayout(text, getFont(), frc);
        layout.draw(g2d, (float)loc.getX(), (float)loc.getY());

        Rectangle2D bounds = layout.getBounds();
        bounds.setRect(bounds.getX()+loc.getX(), bounds.getY()+loc.getY(), bounds.getWidth(), bounds.getHeight());
        g2d.draw(bounds);
    }

    private static void createAndShowUI()
    {
        DrawTest text = new DrawTest("This is some ugly test i");

        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( text );
        frame.setSize(400, 200);
        frame.setLocationByPlatform( true );
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowUI();
            }
        });
    }
}