import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;

public class SSCCE extends JPanel
{
    private List<JTextField> textFields = new ArrayList<JTextField>();

    public SSCCE()
    {
        setLayout( new BorderLayout() );
        JPanel textFieldPanel = new JPanel();

        for (int i = 0; i < 7; i++)
        {
            JTextField tf = new JTextField(2);
            tf.setEditable( false );
            textFieldPanel.add( tf );
            textFields.add( tf );
        }

        ActionListener al = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (textFields.size() == 0)
                {
                    System.out.println("Text Fields are full");
                    return;
                }

                JTextField tf = textFields.remove(0);
                JButton button = (JButton)e.getSource();
                String text = e.getActionCommand();
                tf.setText( text );
            }
        };

        JPanel buttonPanel = new JPanel( new GridLayout(0, 7) );

        for (int i = 0; i < 14; i++)
        {
            JButton button = new JButton("" + i);
            button.addActionListener( al );
            buttonPanel.add( button );
        }

        add(textFieldPanel, BorderLayout.PAGE_START);
        add(buttonPanel, BorderLayout.CENTER);
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SSCCE());
        frame.setLocationByPlatform( true );
        frame.pack();
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