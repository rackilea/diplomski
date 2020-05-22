import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ArrowListener implements KeyListener {
    /* We keep the window as an instance variable so we can modify it once the event is triggered */
    JFrame frame;

    /* This is the constructor */
    public ArrowListener(JFrame j) {
        frame = j;
    }

    /* This is where the magic happens */
    public void keyPressed(KeyEvent e) {
        /* Modify this with what you actually want it to do */

        /* We clear the panel so we can add new text without any other text behind it */
        frame.getContentPane().removeAll();

        /* We add some text that actually shows the keyCode (left arrow = 37, top = 38, right = 39, bottom = 40) */
        frame.add(new JLabel("Key Code #" + String.valueOf(e.getKeyCode())));

        /* Redrawing the window */
        frame.revalidate();
    }

    /* These two are part of the contract we made when we decided to
     * implement the KeyListener */
    public void keyTyped(KeyEvent e) { /* Do nothing */ }
    public void keyReleased(KeyEvent e) { /* Do nothing */ }
}