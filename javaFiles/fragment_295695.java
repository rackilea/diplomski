import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;

public class SSCCE extends JPanel
{
    public SSCCE()
    {
        add( new JLabel("Label") );
    }

    private static void createAndShowUI()
    {
        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new SSCCE() );
        frame.pack();
        frame.setLocationRelativeTo( null );
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