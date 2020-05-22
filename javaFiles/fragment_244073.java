import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

public class SplashScreenDemo extends JWindow {

    boolean loaded = false;

    public SplashScreenDemo() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();

        setSize((int) width, (int) height);
        setLocation(0, 0);
        getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        setBackground(new Color(0, 0, 0, 1));
        setAlwaysOnTop(true);

    }

    public static void main(final String[] args) {

        final SplashScreenDemo splash = new SplashScreenDemo();
        splash.setVisible(true);

        // run your time-consuming things
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                // display actual frame
                JFrame applicationFrame = new JFrame("Application");
                applicationFrame.setSize(200, 200);
                applicationFrame.setVisible(true);
                // dispose splashscreen
                splash.dispose();

            }
        });

    }

}