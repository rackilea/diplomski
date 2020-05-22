package helloworld;

import java.awt.Graphics;
import javax.swing.JApplet;

public abstract class AnimationBase extends JApplet {
    public void paint(Graphics g) {
        this.drawFrame(g);
    }

    public abstract void drawFrame(Graphics g);
}