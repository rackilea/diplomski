import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class PopupTest extends JFrame
{
    String[] numbers = { "one", "two", "three", "four", "five" };

    public PopupTest()
    {
        getContentPane().setLayout( new FlowLayout() );
        getContentPane().setBackground(Color.YELLOW);

        JButton popup = new JButton("Popup as Popup");
        popup.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                popupPopup(e);
            }
        });
        getContentPane().add(popup);
        JButton window = new JButton("Window as Popup");
        window.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                windowPopup(e);
            }
        });
        getContentPane().add(window);

        JButton menu = new JButton("PopupMenu as Popup");
        menu.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                menuPopup(e);
            }
        });
        getContentPane().add(menu);
    }

    private void popupPopup(ActionEvent e)
    {
        JList list = new JList(numbers);
        list.setSelectedIndex(0);

        PopupFactory factory = PopupFactory.getSharedInstance();
        Popup popup = factory.getPopup(this, list, getLocation().x, getLocation().y+100);
        //popup.show();

        Window window = SwingUtilities.windowForComponent(list);

        if (window != null)
        {
            window.setFocusableWindowState(true);
        }

        popup.show();
        KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent(list);
    }

    private void windowPopup(ActionEvent e)
    {
        JList list = new JList(numbers);
        list.setSelectedIndex(0);

        JWindow window = new JWindow(this);
        window.getContentPane().add(list);
        window.pack();
        window.setVisible(true);
        window.setLocation(getLocation().x + 200, getLocation().y+100);

        window.addWindowListener( new WindowAdapter()
        {
            public void windowDeactivated(WindowEvent e)
            {
                System.out.println("deactivated");
            }
        });
    }

    private void menuPopup(ActionEvent e)
    {
        JList list = new JList(numbers);
        list.setSelectedIndex(0);

        JPopupMenu menu = new JPopupMenu();
        menu.add( new JTextField(10) );
        menu.add( list );

        menu.show((Component)e.getSource(), 0, 100);
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new PopupTest();
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setSize(500, 200);
        frame.setLocationRelativeTo( null );
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