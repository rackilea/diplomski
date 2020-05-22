import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

public class Rotation3 extends JPanel
{
    private Icon icon;
    private Icon rotated;
    private int degrees;

    public Rotation3(BufferedImage image)
    {
        icon = new ImageIcon( image );
        setDegrees( 0 );
        setPreferredSize( new Dimension(600, 600) );
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        double radians = Math.toRadians( degrees );
        rotated = new RotatedIcon(icon, degrees);

        // translate x/y so Icon is rotated around a specific point (300, 300)

        int x = 300 - (rotated.getIconWidth() / 2);
        int y = 300 - (rotated.getIconHeight() / 2);
        rotated.paintIcon(this, g, x, y);

        g.setColor(Color.RED);
        g.fillOval(295, 295, 10, 10);
    }

    public void setDegrees(int degrees)
    {
        this.degrees = degrees;
        double radians = Math.toRadians( degrees );
        rotated = new RotatedIcon(icon, degrees);
        repaint();
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    String path = "dukewavered.gif";
                    ClassLoader cl = Rotation3.class.getClassLoader();
                    BufferedImage bi = ImageIO.read(cl.getResourceAsStream(path));
                    final Rotation3 r = new Rotation3(bi);

                    final JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 360, 0);
                    slider.addChangeListener(new ChangeListener()
                    {
                        public void stateChanged(ChangeEvent e)
                        {
                            int value = slider.getValue();
                            r.setDegrees( value );
                        }
                    });

                    JFrame f = new JFrame();
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    f.add(new JScrollPane(r));
                    f.add(slider, BorderLayout.SOUTH);
                    f.pack();
                    f.setLocationRelativeTo(null);
                    f.setVisible(true);
                }
                catch(IOException e)
                {
                    System.out.println(e);
                }
            }
        });
    }
}