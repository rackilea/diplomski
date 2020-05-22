import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ComboBoxTwo extends JFrame implements ActionListener
{
    private JComboBox mainComboBox;
    private JComboBox subComboBox;
    private Hashtable subItems = new Hashtable();

    public ComboBoxTwo()
    {
        String[] items = { "Select Item", "Color", "Shape", "Fruit" };
        mainComboBox = new JComboBox( items );
        mainComboBox.addActionListener( this );

        getContentPane().add( mainComboBox, BorderLayout.WEST );

        //  Create sub combo box with multiple models

        subComboBox = new JComboBox();
        subComboBox.setPrototypeDisplayValue("XXXXXXXXXX"); // JDK1.4
        getContentPane().add( subComboBox, BorderLayout.EAST );

        String[] subItems1 = { "Select Color", "Red", "Blue", "Green" };
        subItems.put(items[1], subItems1);

        String[] subItems2 = { "Select Shape", "Circle", "Square", "Triangle" };
        subItems.put(items[2], subItems2);

        String[] subItems3 = { "Select Fruit", "Apple", "Orange", "Banana" };
        subItems.put(items[3], subItems3);
    }

    public void actionPerformed(ActionEvent e)
    {
        String item = (String)mainComboBox.getSelectedItem();
        Object o = subItems.get( item );

        if (o == null)
        {
            subComboBox.setModel( new DefaultComboBoxModel() );
        }
        else
        {
            subComboBox.setModel( new DefaultComboBoxModel( (String[])o ) );
        }
    }

    public static void main(String[] args)
    {
        JFrame frame = new ComboBoxTwo();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible( true );
     }
}