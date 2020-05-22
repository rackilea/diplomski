import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseWheelToParent implements MouseWheelListener
{
    private JScrollPane scrollPane;
    private MouseWheelListener[] realListeners;

    public MouseWheelToParent(JScrollPane scrollPane)
    {
        this.scrollPane = scrollPane;
        install();
    }

    public void install()
    {
        if (realListeners != null) return;

        //  Keep track of original listeners so we can use them to
        //  redispatch an altered MouseWheelEvent

        realListeners = scrollPane.getMouseWheelListeners();

        for (MouseWheelListener mwl : realListeners)
        {
            scrollPane.removeMouseWheelListener(mwl);
        }

        //  Intercept events so they can be redispatched

        scrollPane.addMouseWheelListener(this);
    }

    /**
     *  Remove the class as the default listener and reinstall the original
     *  listeners.
     */
    public void uninstall()
    {
        if (realListeners == null) return;

        //  Remove this class as the default listener

        scrollPane.removeMouseWheelListener( this );

        //  Install the default listeners

        for (MouseWheelListener mwl : realListeners)
        {
            scrollPane.addMouseWheelListener( mwl );
        }

        realListeners = null;
    }

//  Implement MouseWheelListener interface

    /**
     *  Redispatch a MouseWheelEvent to the real MouseWheelListeners
     */
    public void mouseWheelMoved(MouseWheelEvent e)
    {
        JScrollPane scrollPane = (JScrollPane)e.getComponent();

        if (scrollPane.getVerticalScrollBar().isVisible())
        {
            //  Redispatch the event to original MouseWheelListener

            for (MouseWheelListener mwl : realListeners)
            {
                mwl.mouseWheelMoved( e );
            }
        }
        else
        {
            dispatchToParent(e, scrollPane);
            return;
        }
    }

    private void dispatchToParent(MouseWheelEvent e, JScrollPane scrollPane)
    {
        Component ancestor = SwingUtilities.getAncestorOfClass(JScrollPane.class, scrollPane);

        MouseWheelEvent mwe = new MouseWheelEvent(
            ancestor,
            e.getID(),
            e.getWhen(),
            e.getModifiers(),
            e.getX(),
            e.getY(),
            e.getXOnScreen(),
            e.getYOnScreen(),
            e.getClickCount(),
            e.isPopupTrigger(),
            e.getScrollType(),
            e.getScrollAmount(),
            e.getWheelRotation());

        ancestor.dispatchEvent(mwe);
    }

    private static void createAndShowUI()
    {
        JPanel panel = new JPanel( new GridBagLayout() );
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        for (int y = 0; y < 10; y++)
        {
            for (int x = 0; x < 5; x++)
            {
                gbc.gridx = x;
                gbc.gridy = y;
                JTextArea textArea = new JTextArea(5, 20);
                JScrollPane scrollPane = new JScrollPane( textArea );
                scrollPane.setMinimumSize( scrollPane.getPreferredSize() );
                new MouseWheelToParent(scrollPane);
                panel.add(scrollPane, gbc);
            }
        }
        JFrame frame = new JFrame("TextAreaSSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new JScrollPane( panel ) );
        frame.setSize(400, 400);
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