import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MainFrame
{
    public MainFrame()
    {
        JFrame f = new JFrame("Helicopter Background Test");
        f.add(new AnotherBackground());
        //setTitle("Helicopter Background Test");  Redundant..
        // Set a preferred size for the content area and pack() the frame instead!
        // setSize(FRAME_WIDTH,FRAME_HEIGHT);
        // setLocationRelativeTo(null); Better to..
        f.setLocationByPlatform(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack(); // Size the GUI - VERY MPORTANT!
        f.setVisible(true);
    }

    public static void main(String[] args)
    {
        new MainFrame();
    }
}

class AnotherBackground extends JPanel
{
    private static int PREFERRED_WIDTH = 400;
    private static int PREFERRED_HEIGHT = 200;

    private BufferedImage heliImage = null;
    private BufferedImage heliLeftImage = null;
    private BufferedImage heliRightImage = null;
    private BufferedImage backImage = null; //getFlippedImage(


    private int heliX = 0;
    private int heliY = 0;

    private int backX = 0;
    private int backY = 0;

    private int frameWidth = 0;
    private int frameHeight = 0;

    private int backWidth = 0;
    private int backHeight = 0;

    public AnotherBackground()
    {
        frameWidth = PREFERRED_WIDTH;
        frameHeight = PREFERRED_HEIGHT;

        this.setFocusable(true);
        this.addKeyListener(new HeliListener());

        try
        {
            heliLeftImage = ImageIO.read(
                new URL("http://imageshack.us/a/img7/2133/helicopter2f.png"));
            heliRightImage = getFlippedImage(heliLeftImage);
            heliImage = heliLeftImage;
            // 2.7 Meg Crap that is an humungous image!  Substitute dummy.
            backImage = getTileImage(250);
            //ImageIO.read(
            //  new URL("http://i.stack.imgur.com/T5uTa.png"));

            backWidth = backImage.getWidth();
            backHeight = backImage.getHeight();

            //HeliPainter l = new HeliPainter();  //  see mention of repaint()
            //new Thread(l).start();
        } catch(IOException ex) {
            // THERE IS NO POINT CONTINUING AFTER THIS POINT!
            // unless it is to pop an option pane error message..
            System.out.println("Problem durinng loading heli image");
        }

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREFERRED_WIDTH, PREFERRED_HEIGHT);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        int normalizeX = (heliRealX-heliX)%backImage.getWidth();
        int normalizeY = (heliRealY-heliY)%backImage.getHeight();
        int timesRepeatX = (getWidth()/backImage.getWidth())+2;
        int timesRepeatY = (getHeight()/backImage.getHeight())+2;

        for (int xx=-1; xx<timesRepeatX; xx++) {
            for (int yy=-1; yy<timesRepeatY; yy++) {
                g.drawImage(
                    backImage,
                    (xx*backImage.getWidth())-normalizeX,
                    (yy*backImage.getHeight())-normalizeY,
                    this);  // A JPanel IS AN ImageObserver!
                g.drawImage(heliImage, heliX, heliY, this);
            }
        }
        g.setColor(Color.BLACK);
    }

    private int heliRealX = 0;
    private int heliRealY = 0;

    class HeliListener extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent e)
        {
            int pad = 5;
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                if(heliX > 0)
                {
                    heliX -= 5;
                }
                else
                {
                    backX += 5;
                }
                heliRealX-=5;
                heliImage = heliLeftImage;
            }
            else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                // correct for image size + padding
                if(heliX+heliImage.getWidth()+pad < getWidth())
                {
                    heliX += 5;
                }
                else
                {
                    backX -= 5;
                }
                heliRealX+=5;
                heliImage = heliRightImage;
            }

            else if (e.getKeyCode() == KeyEvent.VK_UP)
            {
                if(heliY > 0)
                {
                    heliY -= 5;
                }
                else
                {
                    backY += 5;
                }
                heliRealY-=5;
            }

            else if (e.getKeyCode() == KeyEvent.VK_DOWN)
            {
                // correct for image size + padding
                if(heliY+heliImage.getHeight()+pad < getHeight())
                {
                    heliY += 5;
                }
                else
                {
                    backY -= 5;
                }
                heliRealY+=5;
            }
            repaint(); // Replaces need for threads for this simple demo!
        }
    }

    public BufferedImage getFlippedImage(BufferedImage original) {
        BufferedImage bi = new BufferedImage(
            original.getWidth(),
            original.getHeight(),
            BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = bi.createGraphics();

        AffineTransform at = AffineTransform.getTranslateInstance(bi.getWidth(),1d);
        at.concatenate(AffineTransform.getScaleInstance(-1d,1d));
        g.setTransform(at);
        g.drawImage(original,0,0,this);

        g.dispose();
        return bi;
    }

    public BufferedImage getTileImage(int s) {
        BufferedImage bi = new BufferedImage(s,s,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = bi.createGraphics();

        GradientPaint gp1 = new GradientPaint(
            (float)0,(float)s/4, Color.YELLOW,
            (float)s/4,0f, Color.GREEN,
            true);
        g.setPaint(gp1);
        g.fillRect(0,0,s,s);

        int trans = 165;
        GradientPaint gp2 = new GradientPaint(
            (float)s/2,(float)s/2, new Color(255,0,0,trans),
            0f,(float)s/2, new Color(255,255,255,trans),
            true);
        g.setPaint(gp2);
        g.fillRect(0,0,s,s);

        g.dispose();
        return bi;
    }
}