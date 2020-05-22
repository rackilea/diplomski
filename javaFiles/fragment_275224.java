import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class CercuriRandom extends Applet implements MouseListener {

    int x, y, z, r, v, a;
    // class attributes that store the last circle that was drawn
    int lastX, lastY, lastZ;
    Thread t;
    Color culoare;
    Random rand;

    @Override
    public void init() {
        t = new Thread();
        rand = new Random();
        culoare = new Color(r, v, a);
        addMouseListener(this);
    }

    @Override
    public void update(Graphics g){
        // clear the last drawn rectangle (before painting the new one)
        g.clearRect(lastX, lastY, lastZ, lastZ);

        g.setColor(culoare);
        g.fillRoundRect(x, y, z, z, z, z);

        // store the last values in order to delete them on next draw
        lastX = x;
        lastY = y;
        lastZ = z;
        try {
            Thread.sleep(25);
        } catch (InterruptedException e) { }
        //repaint();
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getButton() == MouseEvent.BUTTON1) {
            r = rand.nextInt(256);
            v = rand.nextInt(256);
            a = rand.nextInt(256);
            culoare = new Color(r, v, a);
            x = rand.nextInt(getWidth());
            y = rand.nextInt(getWidth());
            z = rand.nextInt(100);
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

}