import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MultipleGradientPaint.CycleMethod;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class LightEffectTest2
{
    public static void main(String args[])
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new LightEffectTest2();
            }
        });
    }


    public LightEffectTest2()
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new LightEffectPanel2());
        f.setSize(600,600);
        f.setVisible(true);
    }
}


class LightEffectPanel2 extends JPanel implements MouseMotionListener
{
    private Point point = new Point(0,0);
    private BufferedImage image;
    private BufferedImage shadow;

    public LightEffectPanel2()
    {
        image = createExampleImage(600,600);
        shadow = new BufferedImage(image.getWidth(), image.getHeight(),
            BufferedImage.TYPE_INT_ARGB);

        addMouseMotionListener(this);
    }

    private static BufferedImage createExampleImage(int w, int h)
    {
        BufferedImage image = new BufferedImage(w, h, 
            BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        Random random = new Random(0);
        for (int i=0; i<200; i++)
        {
            int x = random.nextInt(w);
            int y = random.nextInt(h);
            Color c = new Color(
                random.nextInt(255),
                random.nextInt(255),
                random.nextInt(255));
            g.setColor(c);
            g.fillOval(x-20, y-20, 40, 40);
        }
        g.dispose();
        return image;
    }


    @Override
    protected void paintComponent(Graphics gr)
    {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D)gr;
        g.drawImage(image, 0,0,null);

        drawLights();

        g.drawImage(shadow, 0,0, null);
    }

    private void drawLights()
    {
        Graphics2D g = shadow.createGraphics();
        g.setComposite(AlphaComposite.Src);
        g.setColor(new Color(0,0,16,240));
        g.fillRect(0,0,getWidth(),getHeight());

        drawLight(g, new Point(100,100));
        drawLight(g, point);

        g.dispose();
    }

    private void drawLight(Graphics2D g, Point pt)
    {
        float radius = 100;
        g.setComposite(AlphaComposite.DstOut);
        Point2D center = new Point2D.Float(pt.x, pt.y);
        float[] dist = {0.0f, 1.0f};
        Color[] colors = {new Color(255,255,255,255), new Color(0,0,0,0) };
        RadialGradientPaint p =
            new RadialGradientPaint(
                center, radius, dist, colors, CycleMethod.NO_CYCLE);
        g.setPaint(p);
        g.fillOval(pt.x-(int)radius,pt.y-(int)radius,(int)radius*2,(int)radius*2);
    }



    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        point = e.getPoint();
        repaint();
    }
}