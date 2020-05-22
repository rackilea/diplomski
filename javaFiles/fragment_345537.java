import java.awt.Dimension;
import javax.swing.JFrame;

public class Game {

    public static void main(String[] args) {
        /* Creating a window (300x400) */
        JFrame frame = new JFrame("Add your own title");
        frame.setPreferredSize(new Dimension(300, 400));

        /* This is the part where we add the keyListener (notice that I am also sending
         * this window as a parameter so that the listener can modify it)*/
        frame.addKeyListener(new ArrowListener(frame));

        /* Making the window visible */
        frame.pack();
        frame.setVisible(true);
    }
}