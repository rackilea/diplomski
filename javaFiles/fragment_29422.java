import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class ScrollSSCCE extends JPanel
{
    public ScrollSSCCE()
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        BoundedRangeModel model = null;

        for (int i = 0; i < 5; i++)
        {
            JLabel label = new JLabel("Flute " + i);
            label.setAlignmentX(JComponent.LEFT_ALIGNMENT);
            add( label );

            JTextArea textArea = new JTextArea(3, 20);
            textArea.setText("Just some text to make a horizontal scroll necessary");
            JScrollPane scrollPane = new JScrollPane( textArea );
            scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.setAlignmentX(JComponent.LEFT_ALIGNMENT);
            add( scrollPane );

            //  Share the horizontal scrollbar model

            JScrollBar horizontal = scrollPane.getHorizontalScrollBar();

            if (i == 0)
                model = horizontal.getModel();
            else
                horizontal.setModel( model );
        }

        //  Create the scrollbar that uses the shared model

        JScrollBar shared = new JScrollBar( JScrollBar.HORIZONTAL );
        shared.setModel( model );
        shared.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        add( shared );
    }

    private static void createAndShowUI()
    {
        JFrame frame = new JFrame("Scroll SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new ScrollSSCCE() );
        frame.setLocationByPlatform( true );
        frame.setSize(200, 400);
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