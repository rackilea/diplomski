// NOTE: This is not really a sophisticated "Benchmark", 
// but gives a rough estimate about the performance

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.image.BufferedImage;

public class TransparentGradientInImagePerformance
{
    public static void main(String[] args)
    {
        int w = 1000;
        int h = 1000;
        BufferedImage image0 = new BufferedImage(w, h,
            BufferedImage.TYPE_INT_ARGB);
        BufferedImage image1 = new BufferedImage(w, h,
            BufferedImage.TYPE_INT_ARGB);

        long before = 0;
        long after = 0;
        int runs = 100;
        for (int radius = 100; radius <=400; radius += 10)
        {
            before = System.nanoTime();
            for (int i=0; i<runs; i++)
            {
                transparitize(image0, w/2, h/2, radius);
            }
            after = System.nanoTime();
            System.out.println(
                "Radius "+radius+" with getRGB/setRGB: "+(after-before)/1e6);

            before = System.nanoTime();
            for (int i=0; i<runs; i++)
            {
                updateGradientAt(image0, image1, new Point(w/2, h/2), radius);
            }
            after = System.nanoTime();
            System.out.println(
                "Radius "+radius+" with paint          "+(after-before)/1e6);
        }
    }

    private static void transparitize(
        BufferedImage imgA, int centerX, int centerY, int r)
    {

        for (int x = centerX - r; x < centerX + r; x++)
        {
            for (int y = centerY - r; y < centerY + r; y++)
            {
                double distance = Math.sqrt(
                    Math.pow(Math.abs(centerX - x), 2) +
                    Math.pow(Math.abs(centerY - y), 2));
                if (distance > r)
                    continue;
                int argb = imgA.getRGB(x, y);
                int a = (argb >> 24) & 255;
                double factor = distance / r;
                argb = (argb - (a << 24) + ((int) (a * factor) << 24));
                imgA.setRGB(x, y, argb);
            }
        }
    }

    private static void updateGradientAt(BufferedImage originalImage,
        BufferedImage imageWithGradient, Point point, int radius)
    {
        Graphics2D g = imageWithGradient.createGraphics();
        g.drawImage(originalImage, 0, 0, null);

        float fractions[] = { 0.0f, 1.0f };
        Color colors[] = { new Color(0, 0, 0, 255), new Color(0, 0, 0, 0) };
        RadialGradientPaint paint = new RadialGradientPaint(point, radius,
            fractions, colors);
        g.setPaint(paint);

        g.setComposite(AlphaComposite.DstOut);
        g.fillOval(point.x - radius, point.y - radius, radius * 2, radius * 2);
        g.dispose();
    }
}