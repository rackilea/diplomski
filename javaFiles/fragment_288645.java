import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListRightClick extends JPanel implements ListSelectionListener
{
    public ListRightClick()
    {
        setLayout( new BorderLayout() );

        final JPopupMenu popup = new JPopupMenu();
        popup.add( new JMenuItem("Do Something1") );
        popup.add( new JMenuItem("Do Something2") );
        popup.add( new JMenuItem("Do Something3") );

        String[] data = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight" };
        JList<String> list = new JList<String>( data );
        list.setVisibleRowCount( 5 );
        list.setComponentPopupMenu( popup );
        list.addListSelectionListener( this );

        list.addMouseListener( new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                if ( SwingUtilities.isRightMouseButton(e) )
                {
                        JList list = (JList)e.getSource();
                        int row = list.locationToIndex(e.getPoint());
                        list.setSelectedIndex(row);
                }
            }

        });

        add( new JScrollPane(list) );
    }

    public void valueChanged(ListSelectionEvent e)
    {
        JList list = (JList)e.getSource();
        System.out.println(list.getSelectedValue());
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("ListRightClick");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ListRightClick(), BorderLayout.NORTH);
        frame.setLocationByPlatform( true );
        frame.pack();
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
    }
}