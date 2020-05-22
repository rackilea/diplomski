public class MyApplet extends Applet {

    Image offscreen;
    boolean pageFlipped = false;
    Thread drawingThread;

    public void init() {
        offscreen = createImage(this.getWidth(), this.getHeight());
        drawingThread = new Thread(new DrawingLoop());
        drawingThread.start();
    }

    public void update(Graphics g) {
        paint(g);
    }
    public void paint(Graphics g) {
        if (!pageFlipped) {
            g.drawImage(offscreen, 0, 0);
            pageFlipped = true;
        }
    }

    class DrawingLoop implements Runnable {
        public void run() {
            while (true) {
                Graphics g = offscreen.getGraphics();
                if (pageFlipped) {
                    // do your graphics code here
                    pageFlipped = false;
                }
            }
        }
    }
}