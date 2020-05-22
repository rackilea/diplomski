import java.awt.Frame;

import javax.swing.*;

public class FrameTest {
    public static void main(String[] args) throws InterruptedException {

        // Create a test frame
        JFrame frame = new JFrame("Hello");
        frame.add(new JLabel("Minimize demo"));
        frame.pack();

        // Show the frame
        frame.setVisible(true);

        // Sleep for 5 seconds, then minimize
        Thread.sleep(5000);
        frame.setState(Frame.ICONIFIED);

        // Sleep for 5 seconds, then restore
        Thread.sleep(5000);
        frame.setState(Frame.NORMAL);

        // Sleep for 5 seconds, then kill window
        Thread.sleep(5000);
        frame.setVisible(false);
        frame.dispose();

        // Terminate test
        System.exit(0);
    }
}