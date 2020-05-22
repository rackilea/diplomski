public class FrameTest { //not a subclass from frame

    public static void main(String[] args) {
        //FIXME look at SwingUtilities invokeLater
        new FrameTest().createAndShow(); //because it's just a starter
    }

    private JFrame frame;
    private BufferStrategy bufferStrategy;
    private Rectangle screenBounds;
    private GraphicsDevice myScreen;
    private boolean isRunning = false;

    private void createAndShow() {
    try {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment(); 
        myScreen = env.getDefaultScreenDevice(); //maybe select a certain device
        GraphicsConfiguration gConf = myScreen.getDefaultConfiguration(); //maybe setup a different configuration
        screenBounds = gConf.getBounds();

        frame = new JFrame(gConf);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setUndecorated(true);
        frame.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                goExit();
            }

        });
        frame.setVisible(true);
        myScreen.setFullScreenWindow(frame);

        bufferStrategy = null;
        BufferCapabilities bcaps = gConf.getBufferCapabilities();
        int amountBuffer = 0;
        if (bcaps.isMultiBufferAvailable() ){               
            amountBuffer = 3;
        }else {
            amountBuffer = 2;
        }
        frame.createBufferStrategy(amountBuffer, bcaps);
        bufferStrategy = frame.getBufferStrategy();

        isRunning = true;
        startRendering(); //starts a render loop

        startUniverse(); //starts the physic calculations

        System.out.println("created a buffer with "+amountBuffer+" pages");

    } catch (HeadlessException e) {
    } catch (AWTException e) {
    }

}

    //this is an example caluclation
    private double xpos = 0;
    private double ypos = 0;
    private double xCenter = 0;
    private double yCenter = 0;
    private double radius = 100;
    private double dAngle = 0;
    private double angle = (2d * Math.PI / 360d);


    private void startUniverse() {
        Runnable r = new Runnable() {

            @Override
            public void run() {

                while(isRunning){
                    //this is the example calculation
                    xCenter = screenBounds.getCenterX();
                    yCenter = screenBounds.getCenterY();                    
                    dAngle = dAngle + angle;                    
                    xpos = xCenter + radius*(Math.sin(dAngle) );
                    ypos = yCenter + radius*(Math.cos(dAngle) );

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread t = new Thread(r); //create and...
        t.setDaemon(true);
        t.start(); //...start the thread
    }

    //this method starts the rendering thread
    //look at the full screen tutorial 
    private void startRendering() {
        Runnable r = new Runnable() {

            @Override
            public void run() {

                while(isRunning){ //an endless loop

                    Graphics g = null;
                    try {
                        g = bufferStrategy.getDrawGraphics();
                        render(g); //render the graphics
                    } finally {
                        if (g != null){
                            g.dispose(); //IMPORTANT - dispose the graphics - MemeoryLeak
                        }
                    }
                    bufferStrategy.show(); //bring it to the front

                    //i strongly recommend to let the render thread sleep a little 
                    //this reduces cpu power - without it it uses 
                    //one of my cpus for 100% (having 8 cpus this means 12.5%)
                    //but when it sleeps 10ms my cpu is down to 1% !!!
                    //try {
                    //  Thread.sleep(10);
                    //} catch (InterruptedException e) {
                    //}
                }
            }
        };

        Thread t = new Thread(r);
        t.setDaemon(true);
        t.start();
    }

    //the render method draws the calculated stuff
    protected void render(Graphics g) {

        //fist, fill with white
        g.setColor(Color.WHITE);
        int x = 0;
        int y = 0;
        int width = screenBounds.width;
        int height = screenBounds.width;
        g.fillRect(x, y, width, height);

        //xpos and ypos was calulated in the other thread       
        g.setColor(Color.BLACK);
        int x_a = (int)xpos;
        int y_a = (int)ypos;
        int x_b = (int)xCenter;
        int y_b = (int)yCenter;

        g.drawLine(x_a, y_a, x_b, y_b);
    }

    //simple method to quit
    protected void goExit() {
        isRunning = false;
        frame.setVisible(false);
        frame.dispose();
        myScreen.setFullScreenWindow(null);     
    }

}