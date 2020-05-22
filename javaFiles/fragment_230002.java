import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.MultipleGradientPaint.CycleMethod;
import java.awt.RadialGradientPaint;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class BorderBlurTest
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

        BufferedImage input = null;
        try
        {
            input = ImageIO.read(new File("KCR0B.jpg"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        BufferedImage output = blurBorder(input, 20);
        f.getContentPane().setLayout(new GridLayout());
        f.getContentPane().add(new ImagePanel(input));
        f.getContentPane().add(new ImagePanel(output));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static BufferedImage blurBorder(BufferedImage input, double border)
    {
        int w = input.getWidth();
        int h = input.getHeight();
        BufferedImage output = new BufferedImage(
            w, h, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g = output.createGraphics();
        g.drawImage(input, 0, 0, null);

        g.setComposite(AlphaComposite.DstOut);
        Color c0 = new Color(0,0,0,255);
        Color c1 = new Color(0,0,0,0);

        double cy = border;
        double cx = border;

        // Left
        g.setPaint(new GradientPaint(
            new Point2D.Double(0, cy), c0,
            new Point2D.Double(cx,cy), c1));
        g.fill(new Rectangle2D.Double(
            0, cy, cx, h-cy-cy));

        // Right
        g.setPaint(new GradientPaint(
            new Point2D.Double(w-cx, cy), c1,
            new Point2D.Double(w,cy), c0));
        g.fill(new Rectangle2D.Double(
            w-cx, cy, cx, h-cy-cy));

        // Top
        g.setPaint(new GradientPaint(
            new Point2D.Double(cx, 0), c0,
            new Point2D.Double(cx, cy), c1));
        g.fill(new Rectangle2D.Double(
            cx, 0, w-cx-cx, cy));

        // Bottom
        g.setPaint(new GradientPaint(
            new Point2D.Double(cx, h-cy), c1,
            new Point2D.Double(cx, h), c0));
        g.fill(new Rectangle2D.Double(
            cx, h-cy, w-cx-cx, cy));


        // Top Left
        g.setPaint(new RadialGradientPaint(
            new Rectangle2D.Double(0, 0, cx+cx, cy+cy),
            new float[]{0,1}, new Color[]{c1, c0}, CycleMethod.NO_CYCLE));
        g.fill(new Rectangle2D.Double(0, 0, cx, cy));

        // Top Right
        g.setPaint(new RadialGradientPaint(
            new Rectangle2D.Double(w-cx-cx, 0, cx+cx, cy+cy),
            new float[]{0,1}, new Color[]{c1, c0}, CycleMethod.NO_CYCLE));
        g.fill(new Rectangle2D.Double(w-cx, 0, cx, cy));

        // Bottom Left
        g.setPaint(new RadialGradientPaint(
            new Rectangle2D.Double(0, h-cy-cy, cx+cx, cy+cy),
            new float[]{0,1}, new Color[]{c1, c0}, CycleMethod.NO_CYCLE));
        g.fill(new Rectangle2D.Double(0, h-cy, cx, cy));

        // Bottom Right
        g.setPaint(new RadialGradientPaint(
            new Rectangle2D.Double(w-cx-cx, h-cy-cy, cx+cx, cy+cy),
            new float[]{0,1}, new Color[]{c1, c0}, CycleMethod.NO_CYCLE));
        g.fill(new Rectangle2D.Double(w-cx, h-cy, cx, cy));

        g.dispose();

        return output;
    }


    static class ImagePanel extends JPanel
    {
        private final BufferedImage image;

        ImagePanel(BufferedImage image)
        {
            this.image = image;
        }

        @Override
        public Dimension getPreferredSize()
        {
            if (super.isPreferredSizeSet())
            {
                return super.getPreferredSize();
            }
            return new Dimension(image.getWidth(), image.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            int s = 8;
            int w = getWidth();
            int h = getHeight();
            for (int x=0; x<w; x++)
            {
                for (int y=0; y<h; y++)
                {
                    if (((x+y) & 1) == 0)
                    {
                        g.setColor(Color.WHITE);
                    }
                    else
                    {
                        g.setColor(Color.LIGHT_GRAY);
                    }
                    g.fillRect(x*s,y*s,s,s);
                }
            }
            g.drawImage(image, 0, 0, null);
        }
    }

}