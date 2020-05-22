package FishGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author alexr
 */
public class Keyboard implements KeyListener {
    private static boolean[] keys = new boolean[1024];

    public static boolean isKeyDown(int keyCode) {
        if(0 <= keyCode && keyCode < keys.length) 
            return keys[keyCode];

        return false;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(0 <= keyCode && keyCode < keys.length) 
            keys[keyCode] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(0 <= keyCode && keyCode < keys.length) 
            keys[keyCode] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

}