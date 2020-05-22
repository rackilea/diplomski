import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.*;
import javax.swing.text.*;
import java.io.*;

public class ResizeSSCCE extends JPanel
{
    Image original;
    Image scaled;

    public ResizeSSCCE()
    {
        original = new ImageIcon( "mong.jpg" ).getImage();
        scaled = original;
        scaleImage();

        ComponentListener cl = new ComponentAdapter()
        {
            @Override
            public void componentResized(ComponentEvent e)
            {
                scaleImage();
            }
        };

        addComponentListener(cl);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        if (scaled != null)
            g.drawImage(scaled, 0, 0, this);
//          g.drawImage(original, 0, 0, getWidth(), getHeight(), this);
    }

    private void scaleImage()
    {
        if (getHeight() * getWidth() != 0)
            scaled = original.getScaledInstance(getWidth(), getHeight(), Image.SCALE_FAST);
    }

    private static void createAndShowUI()
    {
        JFrame frame = new JFrame("ResizeSSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new ResizeSSCCE() );
        frame.setSize(200, 200);
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