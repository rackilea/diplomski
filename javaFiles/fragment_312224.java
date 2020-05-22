public class Game extends Canvas implements Runnable {
    private static final long serialVersionUID = -2713820159854096116L;
    public static final int WIDTH = 640, HEIGHT = 700;
    private Thread thread;
    private boolean running = false;
    public static boolean paused = false;

    // fields previously in Mouse moved here:
    private Image dbImage;
    private Graphics dbg;

    // mouse field so we can reuse it
    private Mouse mouse;

    public Game() {
        // we create an instance of mouse and use it as MouseMotionListener
        mouse = new Mouse();
        this.addMouseMotionListener(mouse);
        new Window(WIDTH, HEIGHT, "A Game", this);
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.requestFocus();
        long LastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - LastTime) / ns;
            LastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running)
                render();
            frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {

    }

    private void render() {

    }

    public static void main(String args[]) {
        new Game();
    }

    // paint methods previously in Mouse moved here:
    @Override
    public void paint(Graphics g) {
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, this);
    }

    public void paintComponent(Graphics g) {
        if (mouse.mouseDragged) {
            g.setColor(Color.DARK_GRAY);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(mouse.mx, mouse.my, 20, 20);
        }
        else {
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.DARK_GRAY);
            g.fillRect(mouse.mx, mouse.my, 20, 20);
        }
        repaint();
    }
}