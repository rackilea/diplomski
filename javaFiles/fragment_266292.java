import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.*;
import java.io.*;
import javax.imageio.*;
import java.net.*;

public class SSCCE extends JPanel
{
    private Image image;

    SSCCE()
    {
        try
        {
            image = ImageIO.read(new URL("http://i68.tinypic.com/2ceja8i.png"));

        }
        catch (IOException ioe)
        {
            System.out.println("Unable to fetch image.");
            ioe.printStackTrace();
        }

        setLayout( new BorderLayout() );

        JLabel background = new JLabel( new ImageIcon(image) );
        background.setLayout( new FlowLayout(FlowLayout.LEFT) );
        add( background );

        JPanel buttonPanel = new JPanel( new GridLayout(0, 3, 6, 5) );
        buttonPanel.setBorder( new EmptyBorder(338, 233, 0, 0) );

        buttonPanel.setOpaque( false );

        for (int i = 0; i < 6; i++)
        {
            JButton button = new JButton("Button " + i);
            button.setPreferredSize( new Dimension(160, 45) );
            buttonPanel.add(button);
        }

        background.add( buttonPanel );
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SSCCE());
        frame.pack();
        frame.setLocationByPlatform( true );
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