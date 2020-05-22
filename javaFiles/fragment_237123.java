import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class PaintBrushCursor
{
    public static Cursor createCursor(int brushSize)
    {
        Dimension bestSize = Toolkit.getDefaultToolkit().getBestCursorSize(0, 0);

        BufferedImage image = new BufferedImage(bestSize.width, bestSize.height, BufferedImage.TYPE_INT_ARGB );
        Graphics2D g2d = (Graphics2D)image.getGraphics();
        g2d.setColor( Color.BLACK );

        //  draw center point

        int ovalX = (bestSize.width - brushSize) / 2;
        int ovalY = (bestSize.height - brushSize) / 2;

        g2d.fillOval(ovalX, ovalY, brushSize, brushSize);

        //  draw guidelines

        int centerX = bestSize.width / 2;
        int centerY = bestSize.height / 2;
        int offset = (brushSize / 2) + 5;
        int length = 5;

        g2d.drawLine(centerX - offset - length, centerY, centerX - offset, centerY);
        g2d.drawLine(centerX + offset, centerY, centerX + offset + length, centerY);

        g2d.drawLine(centerX, centerY - offset - length, centerX, centerY - offset);
        g2d.drawLine(centerX, centerY + offset, centerX, centerY + offset + length);

        Point hotSpot = new Point(centerX, centerY);

        return Toolkit.getDefaultToolkit().createCustomCursor(image, hotSpot, "PaintBrush" );
    }

    private static void createAndShowGUI()
    {
        JPanel panel = new JPanel();
        panel.setCursor( PaintBrushCursor.createCursor(7) );

        JFrame frame = new JFrame("Paint BrushC ursor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( panel );
        frame.setLocationByPlatform( true );
        frame.setSize(200, 200);
        frame.setVisible( true );
    }

    public static void main(String[] args)
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