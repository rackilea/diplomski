import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

public class Rotation2 extends JPanel
{
    BufferedImage image;
    int degrees;
    int point = 250;

    public Rotation2(BufferedImage image)
    {
        this.image = image;
        setDegrees( 0 );
        setPreferredSize( new Dimension(600, 600) );
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g.create();

        double radians = Math.toRadians( degrees );
        g2.translate(point, point);
        g2.rotate(radians);
        g2.translate(-image.getWidth(this) / 2, -image.getHeight(this) / 2);
        g2.drawImage(image, 0, 0, null);

        g2.dispose();

        g.setColor(Color.RED);
        g.fillOval(point - 5, point - 5, 10, 10);
    }

    public void setDegrees(int degrees)
    {
        this.degrees = degrees;
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
//                  String path = "mong.jpg";
                    String path = "dukewavered.gif";
                    ClassLoader cl = Rotation2.class.getClassLoader();
                    BufferedImage bi = ImageIO.read(cl.getResourceAsStream(path));
                    final Rotation2 r = new Rotation2(bi);

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