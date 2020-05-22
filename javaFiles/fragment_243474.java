public class Game extends Canvas implements Runnable {

    // resolution
    public static final int     WIDTH         = 640;
    public static final int     HEIGHT        = 480;

    // window title
    private static final String TITLE         = "Title";

    /**
     * Number of logical/physical updates per real second
     */
    private static final int    UPDATE_RATE   = 60;

    /**
     * Number of rendering buffers
     */
    private static final int    BUFFERS_COUNT = 3;

    /**
     * Value of a second in NanoSeconds DO NOT CHANGE!
     */
    private static final long   NANOS_IN_SEC  = 1000000000L;

    /**
     * Update interval in double precision NanoSeconds DO NOT CHANGE!
     */
    private static final double UPDATE_SCALE  = (double) NANOS_IN_SEC / UPDATE_RATE;

    private JFrame              window;
    private Thread              gameThread;
    private boolean             running;

    // temp values 
    int                         x             = 0;
    int                         y             = 0;

    ////////////////

    public Game(JFrame window) {
        this.window = window;
        this.running = false;

        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        this.window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        // properly ends the game by calling stop when window is closed
        this.window.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                stop();
                super.windowClosing(e);
                System.exit(0);
            }
        });

        this.window.getContentPane().add(this);
        this.window.setResizable(false);
        this.window.pack();
        this.window.setLocationRelativeTo(null);
        this.window.setVisible(true);
    }

    // starts the game
    public synchronized void start() {
        if (running)
            return;

        running = true;
        gameThread = new Thread(this);
        gameThread.start();
        System.out.println("Game thread started");
        System.out.println("UPDATE_RATE: " + UPDATE_RATE);
    }

    // ends the game
    public synchronized void stop() {
        if (!running)
            return;

        running = false;
        boolean retry = true;
        while (retry) {
            try {
                gameThread.join();
                retry = false;
                System.out.println("Game thread stoped");
            } catch (InterruptedException e) {
                System.out.println("Failed sopping game thread, retry in 1 second");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    private void update() {
        // this will run UPDATE_RATE times a second
        x++;
        y++;
    }

    private void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(BUFFERS_COUNT);
            return;
        }

        Graphics2D g2d = (Graphics2D) bs.getDrawGraphics().create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        clear(g2d, 0);

        // render here
        g2d.setColor(Color.red);
        g2d.fillRect(x, y, 50, 50);
        //////////////

        g2d.dispose();

        bs.show();
    }

    private void clear(Graphics2D g2d, int shade) {
        g2d.setColor(new Color(shade, shade, shade));
        g2d.fillRect(0, 0, WIDTH, HEIGHT);
    }

    // game loop thread
    public void run() {
        long startTime = System.currentTimeMillis();
        long tick = 1000;

        int upd = 0;
        int fps = 0;

        double updDelta = 0;

        long lastTime = System.nanoTime();

        while (running) {
            long now = System.nanoTime();
            updDelta += (now - lastTime) / UPDATE_SCALE;
            lastTime = now;

            while (updDelta > 1) {
                update();
                upd++;
                updDelta--;
            }
            render();
            fps++;

            if (System.currentTimeMillis() - startTime > tick) {
                window.setTitle(TITLE + " || Upd: " + upd + " | Fps: " + fps);
                upd = 0;
                fps = 0;
                tick += 1000;
            }

            try {
                Thread.sleep(5); // always a good idea to let is breath a bit
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}