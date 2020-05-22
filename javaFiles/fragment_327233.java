import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SSCCE extends JPanel
{
    public SSCCE()
    {
        setLayout( new BorderLayout() );

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("1", new JPanel());
        tabbedPane.add("2", new JPanel());
        add(tabbedPane);

        AnimatedIcon icon = new AnimatedIcon(tabbedPane, 250, 3);
        ImageIcon duke = new ImageIcon( "copy16.gif" );
        icon.addIcon( duke );

        for (int angle = 30; angle < 360; angle += 30)
        {
            icon.addIcon( new RotatedIcon(duke, angle) );
        }

        tabbedPane.setIconAt(0, icon);
        icon.start();
    }


    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SSCCE());
        frame.setLocationByPlatform( true );
        frame.pack();
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