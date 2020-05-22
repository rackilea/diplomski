import javax.swing.*;
import java.awt.*;

public class TabbedPaneLeft extends JPanel
{
    private JTabbedPane tabbedPane;

    public TabbedPaneLeft()
    {
        ImageIcon icon = new ImageIcon( "copy16.gif" );

        tabbedPane = new JTabbedPane();
        tabbedPane.setTabPlacement(JTabbedPane.LEFT);
        add( tabbedPane );

        initTabComponent(icon, "Tab 1");
        initTabComponent(icon, "Tabbed Pane 2");
        initTabComponent(icon, "Tab 3");

        adjustTabComponentSize();
    }

    private void initTabComponent(Icon icon, String text)
    {
        JLabel label = new JLabel( text );
        label.setPreferredSize( new Dimension(300, 300) );

        tabbedPane.addTab(null, null, label);

        JLabel tabLabel = new JLabel( text );
        tabLabel.setIcon( icon );
        //tabLabel.setHorizontalAlignment(JLabel.LEFT); // doesn't work
        //tabLabel.setAlignmentX(0.0f); // doesn't work
        tabbedPane.setTabComponentAt(tabbedPane.getTabCount() - 1, tabLabel);
    }

    private void adjustTabComponentSize()
    {
        int width = 0;

        //  Find the width of the larget tab

        for (int i = 0; i < tabbedPane.getTabCount(); i++)
        {
            Dimension d = tabbedPane.getTabComponentAt(i).getPreferredSize();
            width = Math.max(width, d.width);
        }

        //  Set the width of all tabs to match the largest

        for (int i = 0; i < tabbedPane.getTabCount(); i++)
        {
            Component tabComponent = tabbedPane.getTabComponentAt(i);
            Dimension d = tabComponent.getPreferredSize();
            d.width = width;
            tabComponent.setPreferredSize( d );
        }
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TabbedPaneLeft());
        frame.pack();
        frame.setLocationByPlatform( true );
        frame.setVisible( true );
    }

    public static void main(String[] args) throws Exception
    {
        java.awt.EventQueue.invokeLater( () -> createAndShowGUI() );
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