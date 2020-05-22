import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Main
{
    private Main()
    {
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI()
    {
        final FooFrame frame;

        frame = new FooFrame();
        frame.setupGUI();
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}