import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.Image;
import java.net.URL;

public class LP3 extends JPanel
{
    public static BufferedImage image;
    public static BufferedImage image2;
    private JFrame frame = new JFrame();
    private PanClass panel = new PanClass();

    public LP3()
    {
        setOpaque(true);
        try
        {               
            image2=ImageIO.read(new URL(
                "https://encrypted-tbn1.gstatic.com/images?q=tbn:" + 
                "ANd9GcQCluuYpyVQYZuADHAYIfpkRO7SaWMn0OCM_nGH6Tr2SCFtGtE_"));     
        }
        catch (IOException e)
        {
            //Nothing
            e.printStackTrace();
        }           
    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(300, 300));
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(image2,0,0,this);
    }

    private void displayGUI()
    {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(true);
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(0, 1, 5, 5));
        contentPane.add(panel);
        contentPane.add(this);
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setVisible(true); 
    }

    public static void main(String[] args)
    {
        Runnable runnable = new Runnable()
        {
            @Override
            public void run()
            {
                new LP3().displayGUI();
            }
        };
        EventQueue.invokeLater(runnable);
    }
}

class PanClass extends JPanel
{
    private static BufferedImage theimage;
    private static BufferedImage image2;

    public PanClass()
    {
        setOpaque(true);
        try
        {                 
            theimage = ImageIO.read(
                new URL(
                    "https://encrypted-tbn0.gstatic.com/" + 
                    "images?q=tbn:ANd9GcR5PNwAcLVjphhST_" + 
                    "S-K_dU0CEAuXM0g4oc1-v1r-z5VJFuemOD"));
        }
        catch (IOException e)
        {
            //Not handled.
            e.printStackTrace();
        }
    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(300, 300));
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(theimage, 0, 0, this);
    }
}