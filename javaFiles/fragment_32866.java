import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TransparentGradientInImage
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

        TransparentGradientInImagePanel p =
            new TransparentGradientInImagePanel();
        f.getContentPane().add(p);
        f.setSize(800, 600);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

}

class TransparentGradientInImagePanel extends JPanel
{
    private BufferedImage background;
    private BufferedImage originalImage;
    private BufferedImage imageWithGradient;

    TransparentGradientInImagePanel()
    {
        try
        {
            background = ImageIO.read(
                new File("night-sky-astrophotography-1.jpg"));
            originalImage = convertToARGB(ImageIO.read(new File("7bI1Y.jpg")));
            imageWithGradient = convertToARGB(originalImage);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        addMouseMotionListener(new MouseAdapter()
        {
            @Override
            public void mouseMoved(MouseEvent e)
            {
                updateGradientAt(e.getPoint());
            }
        });
    }


    private void updateGradientAt(Point point)
    {
        Graphics2D g = imageWithGradient.createGraphics();
        g.drawImage(originalImage, 0, 0, null);

        int radius = 100;
        float fractions[] = { 0.0f, 1.0f };
        Color colors[] = { new Color(0,0,0,255), new Color(0,0,0,0) };
        RadialGradientPaint paint = 
            new RadialGradientPaint(point, radius, fractions, colors);
        g.setPaint(paint);

        g.setComposite(AlphaComposite.DstOut);
        g.fillOval(point.x - radius, point.y - radius, radius * 2, radius * 2);
        g.dispose();
        repaint();
    }

    private static BufferedImage convertToARGB(BufferedImage image)
    {
        BufferedImage newImage =
            new BufferedImage(image.getWidth(), image.getHeight(),
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newImage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return newImage;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        g.drawImage(imageWithGradient, 0, 0, null);
    }
}