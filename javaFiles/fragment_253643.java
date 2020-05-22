import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class BoxExample extends JFrame
{
    public BoxExample()
    {
        Box box = Box.createHorizontalBox();
        box.setBorder( new EmptyBorder(5, 5, 5, 5) );
        Dimension size = new Dimension(100, 25);

        box.add( createButton("Button1", size) );
        box.add( createStrut() );
        box.add( createButton("Button2", size) );
        box.add( createStrut() );
        box.add( createButton("Button3", size) );
        box.add( createStrut() );
        box.add( createButton("Button4", size) );

        add( box );
    }

    private JButton createButton(String text, Dimension size)
    {
        JButton button = new JButton(text);
        button.setPreferredSize( size );
        button.setMinimumSize( size );
        button.setMaximumSize( size );
        return button;
    }

    private Component createStrut()
    {
        JComponent component = (JComponent)Box.createHorizontalStrut(5);
        component.setMinimumSize(new Dimension(0, 0));
        component.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
        return component;
    }

    public static void main(String[] args)
    {
        BoxExample frame = new BoxExample();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }
}