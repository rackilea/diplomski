import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.basic.*;

public class ComboBoxFonts extends JFrame implements ItemListener
{
    JTextArea textArea;
    JComboBox comboBox;

    public ComboBoxFonts()
    {
        Font font = new Font("Courier New", Font.PLAIN, 16);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment ();
        Font [] fonts = ge.getAllFonts ();

        comboBox = new JComboBox( fonts );
        comboBox.setFont( font);
        comboBox.addItemListener( this );
        add( comboBox, BorderLayout.SOUTH );

        textArea= new JTextArea("Some text - \u16e6 -", 3, 20);
        textArea.setFont( font.deriveFont( 24.0f) );
        add( new JScrollPane( textArea ) );
    }

    public void itemStateChanged(ItemEvent e)
    {
        Font font = (Font)e.getItem();
        textArea.setFont( font.deriveFont( 24.0f ) );
    }

    public static void main(String[] args)
    {
        ComboBoxFonts frame = new ComboBoxFonts();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible( true );
    }
}