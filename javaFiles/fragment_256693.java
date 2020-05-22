/*
    This works on non editable combo boxes
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.*;
import javax.swing.text.*;

public class ComboBoxAction extends JFrame implements ActionListener
{
    public ComboBoxAction()
    {
        JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.addActionListener( this );

        comboBox.addItem( "Item 1" );
        comboBox.addItem( "Item 2" );
        comboBox.addItem( "Item 3" );
        comboBox.addItem( "Item 4" );

        //  This prevents action events from being fired when the
        //  up/down arrow keys are used on the dropdown menu

        comboBox.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);

        getContentPane().add( comboBox );
        getContentPane().add( new JTextField(), BorderLayout.SOUTH );
    }

    public void actionPerformed(ActionEvent e)
    {
        System.out.println( e.getModifiers() );

        JComboBox comboBox = (JComboBox)e.getSource();
        System.out.println( comboBox.getSelectedItem() );

        //  make sure popup is closed when 'isTableCellEditor' is used

//      comboBox.hidePopup();
    }

    public static void main(String[] args)
    {
        ComboBoxAction frame = new ComboBoxAction();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setVisible( true );
     }
}