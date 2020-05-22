package mousebandymas;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class Mousebandymas extends Applet{
    boolean toFill = false;
    public void init(){
        super.init();
        setSize(500,500);
        setBackground(Color.RED);
        this.addMouseListener(new MouseInsert());
    }
    public void paint(Graphics g){
        g.setColor(Color.GREEN);
        g.drawRect(100, 200, 100, 100);
        g.drawRect(300, 200, 100, 100);
        if (toFill == true){
            g.fillRect(100, 200, 100, 100);
        }
    }

private class MouseInsert implements MouseListener, MouseMotionListener{

public void mouseClicked(MouseEvent e) {
    int mx = e.getX();
    int my = e.getY();
    if (mx > 1){
     toFill = true; // *Here main problem, don't work*
     repaint();
    }
}
public void mouseEntered(MouseEvent e) {}
public void mouseExited(MouseEvent e) {}
public void mousePressed(MouseEvent e) {}
public void mouseReleased(MouseEvent e) {}
public void mouseDragged(MouseEvent e) {}
public void mouseMoved(MouseEvent e) {}

}

}