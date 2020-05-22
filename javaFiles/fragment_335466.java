import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;

public class ScrollPaneSSCCE
{
    private static void createAndShowUI()
    {
        JPanel center = new JPanel();
        center.setPreferredSize( new Dimension(300, 300) );
        center.setBackground( Color.RED );

        JPanel main = new JPanel( new GridBagLayout() );
        main.add(center, new GridBagConstraints());

        JFrame frame = new JFrame("Basic ScrollPaneSSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new JScrollPane( main ) );
        frame.setSize(400, 400);
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