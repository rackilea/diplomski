package timerdemo;

import javax.swing.SwingUtilities;

/**
 *
 * @author ottp
 */
public class TimerDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Gui();
            }
        });

    }
}