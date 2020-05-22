package game;

import java.awt.Graphics;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import javax.swing.JApplet;

public class Gamer extends JApplet implements KeyEventDispatcher {
    private int x = 50, y = 50;

    @Override
    public void init() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(this);
    }

    @Override
    public void paint(Graphics g) // will draw the background and the character
    {
        super.paint(g); // <- added to your code to clear the background
                        //         before re-painting the new square

        g.fillRect(x, y, 20, 20);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch( keyCode )
        {
        case KeyEvent.VK_UP:
            if( y>0 )  //when up key is pressed and the position of the player is not on the edge
            {
                y=y-19;
                repaint();
            }
            break;
        case KeyEvent.VK_DOWN:
            if( y<171 ) //when down key is pressed and the position of the player is not on the edge
            {
                y=y+19;
                repaint();
            }
            break;
        case KeyEvent.VK_LEFT:
            if( x>0 )
            {
                x=x-15;
                repaint();
            }
            break;
        case KeyEvent.VK_RIGHT:
            if( x<285 )
            {
                x=x+15;
                repaint();
            }
            break;
        }
        return false;
    }

}