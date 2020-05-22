import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class SmoothResize extends Frame implements Renderable {

    public static void main(String[] args) {
        Toolkit.getDefaultToolkit().setDynamicLayout(true);
        System.setProperty("sun.awt.noerasebackground", "true");
        SmoothResize srtest = new SmoothResize();
        RenderThread renderThread = new RenderThread(srtest);
        renderThread.start();
        srtest.setSize(100, 100);
        srtest.setVisible(true);
    }

    public SmoothResize() {
    }

    public void addNotify() {
        super.addNotify();
        createBufferStrategy(2);
    }

    @Override
    public Dimension getSize() {
        return new Dimension(getWidth(), getHeight());
    }

    @Override
    public Graphics acquireGraphics() {
        return this.getGraphics();
    }
}

class RenderThread extends Thread {

    Renderable target;
    Dimension last_size = new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);

    public RenderThread(Renderable d) {
        if (d == null) {
            throw new NullPointerException("Drawable target cannot be null.");
        }
        target = d;

    }

    @Override
    public void run() {
        while (true) {
            render(false);
        }
    }

    private synchronized void render(boolean force) {
        Dimension size;
        do {
            size = target.getSize();
            if (size == null) {
                return;
            }

            Graphics draw = target.acquireGraphics();
            if (draw == null) {
                return;
            }
            draw.setPaintMode();
            int w = (int) (((double) (size.width)) / 2 + 0.5);
            int h = (int) (((double) (size.height)) / 2 + 0.5);
            draw.setColor(Color.YELLOW);
            draw.fillRect(0, h, w, h);
            draw.fillRect(w, 0, w, h);
            draw.setColor(Color.BLACK);
            draw.fillRect(0, 0, w, h);
            draw.fillRect(w, h, w, h);
            draw.dispose();
            // Repeat the rendering if the target changed size
        } while (!size.equals(target.getSize()));
    }
}

interface Renderable {

    public Graphics acquireGraphics();

    public Dimension getSize();
}