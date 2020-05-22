import java.awt.*;

public class FrameTest
{
    public static void main (String args[]) throws Exception
    {
        // Create a test frame
        Frame frame = new Frame("Hello");
        frame.add ( new Label("Minimize demo") );
        frame.pack();

        // Show the frame
        frame.setVisible (true);

        // Sleep for 5 seconds, then minimize
        Thread.sleep (5000);
        frame.setState ( Frame.ICONIFIED );
        frame.setVisible(false);
        // Sleep for 5 seconds, then restore
        Thread.sleep (5000);
        frame.setState ( Frame.NORMAL );
        frame.setVisible(true);

        // Sleep for 5 seconds, then kill window
        Thread.sleep (5000);
        frame.setVisible (false);
        frame.dispose();

        // Terminate test
        System.exit(0);
    }
}