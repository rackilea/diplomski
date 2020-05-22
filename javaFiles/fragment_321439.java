import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;

public class GfxApp extends Panel {

    private int td = 200;       //Time Delay on graphics

    public void paint(Graphics g) {

        g.setFont(new Font("Arial", Font.BOLD, 28));
        g.drawString("Lab 33A 80/100 POINT VERSUIN", 300, 50);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("DRAWING A LINKED LIST AS A STACK", 50, 215);
        g.drawString("DRAWING A LINKED LIST AS A QUEUE", 50, 415);
        drawStack(g);
        drawQueue(g);

    }

    public void drawStack(Graphics g) {
        g.setFont(new Font("ARIAL", Font.BOLD, 20));
    }

    public void drawQueue(Graphics g) {
        g.setFont(new Font("ARIAL", Font.BOLD, 20));
    }
}