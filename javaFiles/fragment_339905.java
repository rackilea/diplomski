/**
 * @author iGeeks
 * @date   2015-01-08
 */

package ly.gress.frames;

import javax.swing.JFrame;

public class TestTwoFrames implements Runnable{

    JFrame theFrame;


    public TestTwoFrames(JFrame f) {
        this.theFrame = f;
    }


    // Run two Frames in separate therads
    public static void main(String[] arguments) {
        JFrame f1 = new JFrame("f1 title");
        JFrame f2 = new JFrame("f2 title");

        Thread t1 = new Thread(new TestTwoFrames(f1));
        Thread t2 = new Thread(new TestTwoFrames(f2));

        t1.start();
        t2.start();
    }


    @Override
    public void run() {
        theFrame.setSize(200, 200);
        theFrame.setVisible(true);

        // Attention: This closes the app, and therefore both frames!
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

} // end class TestTwoFrames