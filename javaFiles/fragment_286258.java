import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ListToolTip extends JFrame
{
    public ListToolTip()
    {
        DefaultListModel model = new DefaultListModel();
        model.addElement("one");
        model.addElement("two");
        model.addElement("three");
        model.addElement("four");
        model.addElement("five");
        model.addElement("six");
        model.addElement("seven");
        model.addElement("eight");
        model.addElement("nine");
        model.addElement("ten");

        JList list = new JList( model )
        {
            public String getToolTipText( MouseEvent e )
            {
                int row = locationToIndex( e.getPoint() );
                Object o = getModel().getElementAt(row);
                return o.toString();
            }

            public Point getToolTipLocation(MouseEvent e)
            {
                int row = locationToIndex( e.getPoint() );
                Rectangle r = getCellBounds(row, row);
                return new Point(r.width, r.y);
            }
        };

        JScrollPane scrollPane = new JScrollPane( list );
        getContentPane().add( scrollPane );
    }

    public static void main(String[] args)
    {
        ListToolTip frame = new ListToolTip();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.setSize(400, 100);
        frame.setVisible( true );
    }
}