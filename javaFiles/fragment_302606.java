import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WindowTest
{
    public static void main(String[] args)
    {

        JFrame frame = new JFrame();
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      frame.setLocation(-200, 0); // uncomment this line to hide the dummy frame
        frame.setVisible( true );

        JWindow window = new JWindow(); // this doesn't work
//      JWindow window = new JWindow(frame); // this works

        window.getContentPane().add( new JTextField(10), BorderLayout.NORTH );
        window.getContentPane().add( new JButton("Button") );
        String[] items = { "Select Item", "Color", "Shape", "Fruit" };
        JComboBox mainComboBox = new JComboBox( items );
        window.getContentPane().add( mainComboBox, BorderLayout.SOUTH );

        window.setBounds(50, 50, 200, 200);
        window.setVisible(true);
        window.getRootPane().setBorder(new javax.swing.border.MatteBorder(4, 4, 4, 4, Color.BLUE));
     }
}