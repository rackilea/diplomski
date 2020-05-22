public class GameLogic {

    public GameLogic() {
        initComponents();
    }

    private void initComponents() {
        JFrame frame = new JFrame("Game Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create the gamepanel
        final GamePanel gp = new GamePanel(600, 500);

        //create panel to hold buttons to start pause and stop the game
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);

        final JButton startButton = new JButton("Start");
        final JButton pauseButton = new JButton("Pause");
        final JButton stopButton = new JButton("Stop");

        pauseButton.setEnabled(false);
        stopButton.setEnabled(false);

        //add listeners to buttons (most of the actions - excuse the pun - takes palce here :)
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //clear enitites currently in array
                gp.clearEntities();


                ArrayList<BufferedImage> ballEntityImages = new ArrayList<>();
                ArrayList<Long> ballEntityTimings = new ArrayList<>();
                ballEntityImages.add(createColouredImage("white", 50, 50, true));
                ballEntityTimings.add(500l);

                Entity ballEntity = new Entity(gp.getWidth() / 2, gp.getHeight() / 2, ballEntityImages, ballEntityTimings);
                ballEntity.RIGHT = true;

                //create images for entities
                ArrayList<BufferedImage> advEntityImages = new ArrayList<>();
                ArrayList<Long> advEntityTimings = new ArrayList<>();
                advEntityImages.add(createColouredImage("orange", 10, 100, false));
                advEntityTimings.add(500l);
                advEntityImages.add(createColouredImage("blue", 10, 100, false));
                advEntityTimings.add(500l);

                //create entities
                AdvancedSpritesEntity player1Entity = new AdvancedSpritesEntity(0, 100, advEntityImages, advEntityTimings);


                ArrayList<BufferedImage> entityImages = new ArrayList<>();
                ArrayList<Long> entityTimings = new ArrayList<>();
                entityImages.add(createColouredImage("red", 10, 100, false));
                entityTimings.add(500l);//as its the only image it doesnt really matter what time we put we could use 0l
                //entityImages.add(createColouredImage("magenta", 100, 100));
                //entityTimings.add(500l); 

                Entity player2Entity = new Entity(gp.getWidth() - 10, 200, entityImages, entityTimings);


                gp.addEntity(player1Entity);
                gp.addEntity(player2Entity);//just a standing still Entity for testing
                gp.addEntity(ballEntity);//just a standing still Entity for testing

                //create Keybingings for gamepanel
                GameKeyBindings gameKeyBindings = new GameKeyBindings(gp, player1Entity, player2Entity);

                GamePanel.running.set(true);

                //start the game loop which will repaint the screen
                runGameLoop(gp);

                startButton.setEnabled(false);
                pauseButton.setEnabled(true);
                stopButton.setEnabled(true);
            }
        });

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                boolean b = GamePanel.paused.get();

                GamePanel.paused.set(!b);//set it to the opposite of what it was i.e paused to unpaused and vice versa

                if (pauseButton.getText().equals("Pause")) {
                    pauseButton.setText("Un-pause");
                } else {
                    pauseButton.setText("Pause");
                }
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GamePanel.running.set(false);
                GamePanel.paused.set(false);

                /* if we want enitites to be cleared and a blank panel shown
                 gp.clearEntities();
                 gp.repaint(); 
                 */
                if (!pauseButton.getText().equals("Pause")) {
                    pauseButton.setText("Pause");
                }
                startButton.setEnabled(true);
                pauseButton.setEnabled(false);
                stopButton.setEnabled(false);
            }
        });

        //add buttons to panel
        buttonPanel.add(startButton);
        buttonPanel.add(pauseButton);
        buttonPanel.add(stopButton);

        //add gamepanel to jframe and button panel
        frame.add(gp);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    //Simply used for testing (to simulate sprites) can create different colored images
    public static BufferedImage createColouredImage(String color, int w, int h, boolean circular) {
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        switch (color.toLowerCase()) {
            case "green":
                g2.setColor(Color.GREEN);
                break;
            case "magenta":
                g2.setColor(Color.MAGENTA);
                break;
            case "red":
                g2.setColor(Color.RED);
                break;
            case "yellow":
                g2.setColor(Color.YELLOW);
                break;
            case "blue":
                g2.setColor(Color.BLUE);
                break;
            case "orange":
                g2.setColor(Color.ORANGE);
                break;
            case "cyan":
                g2.setColor(Color.CYAN);
                break;
            case "gray":
                g2.setColor(Color.GRAY);
                break;
            default:
                g2.setColor(Color.WHITE);
                break;
        }
        if (!circular) {
            g2.fillRect(0, 0, img.getWidth(), img.getHeight());
        } else {
            g2.fillOval(0, 0, img.getWidth(), img.getHeight());
        }
        g2.dispose();
        return img;
    }

    //Starts a new thread and runs the game loop in it.
    private void runGameLoop(final GamePanel gp) {
        Thread loop = new Thread(new Runnable() {
            @Override
            public void run() {
                gp.gameLoop();
            }
        });
        loop.start();
    }

    //Code starts here
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                try {//attempt to set look and feel to nimbus Java 7 and up
                    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                GameLogic gameLogic = new GameLogic();
            }
        });
    }
}

class GameKeyBindings {

    public GameKeyBindings(JComponent gp, final Entity entity, final Entity entity2) {

        gp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, false), "W pressed");
        gp.getActionMap().put("W pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                entity.UP = true;
            }
        });
        gp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true), "W released");
        gp.getActionMap().put("W released", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                entity.UP = false;
            }
        });

        gp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false), "S pressed");
        gp.getActionMap().put("S pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                entity.DOWN = true;
            }
        });
        gp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true), "S released");
        gp.getActionMap().put("S released", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                entity.DOWN = false;
            }
        });

        gp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "down pressed");
        gp.getActionMap().put("down pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                entity2.DOWN = true;
            }
        });
        gp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "down released");
        gp.getActionMap().put("down released", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                entity2.DOWN = false;
            }
        });
        gp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "up pressed");
        gp.getActionMap().put("up pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                entity2.UP = true;
            }
        });
        gp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "up released");
        gp.getActionMap().put("up released", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                entity2.UP = false;
            }
        });
    }
}

class AdvancedSpritesEntity extends Entity {

    public AdvancedSpritesEntity(int x, int y, ArrayList<BufferedImage> images, ArrayList<Long> timings) {
        super(x, y, images, timings);
    }

    void setAnimation(ArrayList<BufferedImage> images, ArrayList<Long> timings) {
        reset();//reset variables of animator class
        setFrames(images, timings);//set new frames for animation
    }
}

class Entity extends Animator {

    private int speed = 5;
    public boolean UP = false, DOWN = false, LEFT = false, RIGHT = false, visible;
    private Rectangle2D.Double rect;

    public Entity(int x, int y, ArrayList<BufferedImage> images, ArrayList<Long> timings) {
        super(images, timings);
        UP = false;
        DOWN = false;
        LEFT = false;
        RIGHT = false;
        visible = true;
        rect = new Rectangle2D.Double(x, y, getCurrentImage().getWidth(), getCurrentImage().getHeight());
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public HashSet<String> getMask(Entity e) {
        HashSet<String> mask = new HashSet<>();
        int pixel, a;
        BufferedImage bi = e.getCurrentImage();//gets the current image being shown
        for (int i = 0; i < bi.getWidth(); i++) { // for every (x,y) component in the given box, 
            for (int j = 0; j < bi.getHeight(); j++) {
                pixel = bi.getRGB(i, j); // get the RGB value of the pixel
                a = (pixel >> 24) & 0xff;
                if (a != 0) {  // if the alpha is not 0, it must be something other than transparent
                    mask.add((e.getX() + i) + "," + (e.getY() - j)); // add the absolute x and absolute y coordinates to our set
                }
            }
        }
        return mask;  //return our set
    }

    // Returns true if there is a collision between object a and object b   
    public boolean checkPerPixelCollision(Entity b) {
        // This method detects to see if the images overlap at all. If they do, collision is possible
        int ax1 = (int) getX();
        int ay1 = (int) getY();

        int ax2 = ax1 + (int) getWidth();
        int ay2 = ay1 + (int) getHeight();

        int bx1 = (int) b.getX();
        int by1 = (int) b.getY();

        int bx2 = bx1 + (int) b.getWidth();

        int by2 = by1 + (int) b.getHeight();

        if (by2 < ay1 || ay2 < by1 || bx2 < ax1 || ax2 < bx1) {
            return false; // Collision is impossible.
        } else { // Collision is possible.
            // get the masks for both images
            HashSet<String> maskPlayer1 = getMask(this);
            HashSet<String> maskPlayer2 = getMask(b);
            maskPlayer1.retainAll(maskPlayer2);  // Check to see if any pixels in maskPlayer2 are the same as those in maskPlayer1
            if (maskPlayer1.size() > 0) {  // if so, than there exists at least one pixel that is the same in both images, thus
                return true;
            }
        }
        return false;
    }

    public void move() {
        if (UP) {
            rect.y -= speed;
        }
        if (DOWN) {
            rect.y += speed;
        }
        if (LEFT) {
            rect.x -= speed;
        }
        if (RIGHT) {
            rect.x += speed;
        }
    }

    @Override
    public void update(long elapsedTime) {
        super.update(elapsedTime);
        getWidth();//set the rectangles height accordingly after image update
        getHeight();//set rectangles height accordingle after update
    }

    public boolean intersects(Entity e) {
        return rect.intersects(e.rect);
    }

    public double getX() {
        return rect.x;
    }

    public double getY() {
        return rect.y;
    }

    public double getWidth() {
        if (getCurrentImage() == null) {//there might be no image (which is unwanted ofcourse but  we must not get NPE so we check for null and return 0
            return rect.width = 0;
        }

        return rect.width = getCurrentImage().getWidth();
    }

    public double getHeight() {
        if (getCurrentImage() == null) {
            return rect.height = 0;
        }
        return rect.height = getCurrentImage().getHeight();
    }
}

class Animator {

    private ArrayList<BufferedImage> frames;
    private ArrayList<Long> timings;
    private int currIndex;
    private long animationTime;
    private long totalAnimationDuration;
    private AtomicBoolean done;//used to keep track if a single set of frames/ an animtion has finished its loop

    public Animator(ArrayList<BufferedImage> frames, ArrayList< Long> timings) {
        currIndex = 0;
        animationTime = 0;
        totalAnimationDuration = 0;
        done = new AtomicBoolean(false);
        this.frames = new ArrayList<>();
        this.timings = new ArrayList<>();
        setFrames(frames, timings);
    }

    public boolean isDone() {
        return done.get();
    }

    public void reset() {
        totalAnimationDuration = 0;
        done.getAndSet(false);
    }

    public void update(long elapsedTime) {
        if (frames.size() > 1) {
            animationTime += elapsedTime;
            if (animationTime >= totalAnimationDuration) {
                animationTime = animationTime % totalAnimationDuration;
                currIndex = 0;
                done.getAndSet(true);
            }
            while (animationTime > timings.get(currIndex)) {
                currIndex++;
            }
        }
    }

    public BufferedImage getCurrentImage() {
        if (frames.isEmpty()) {
            return null;
        } else {
            try {
                return frames.get(currIndex);
            } catch (Exception ex) {//images might have been altered so we reset the index and return first image of the new frames/animation 
                currIndex = 0;
                return frames.get(currIndex);
            }
        }
    }

    public void setFrames(ArrayList<BufferedImage> frames, ArrayList< Long> timings) {
        if (frames == null || timings == null) {//so that constructor super(null,null) cause this to throw NullPointerException
            return;
        }
        this.frames = frames;
        this.timings.clear();
        for (long animTime : timings) {
            totalAnimationDuration += animTime;
            this.timings.add(totalAnimationDuration);
        }
    }
}

class GamePanel extends JPanel {

    private final static RenderingHints textRenderHints = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    private final static RenderingHints imageRenderHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    private final static RenderingHints colorRenderHints = new RenderingHints(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
    private final static RenderingHints interpolationRenderHints = new RenderingHints(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
    private final static RenderingHints renderHints = new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    public static AtomicBoolean running = new AtomicBoolean(false), paused = new AtomicBoolean(false);
    private int width, height, frameCount = 0, fps = 0;
    private ArrayList<Entity> entities = new ArrayList<>();
    private final Random random = new Random();

    public GamePanel(int w, int h) {
        super(true);//make sure double buffering is enabled
        setIgnoreRepaint(true);//mustnt repaint itself the gameloop will do that
        width = w;
        height = h;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    public void addEntity(Entity e) {
        entities.add(e);
    }

    void clearEntities() {
        entities.clear();
    }

    //Only run this in another Thread!
    public void gameLoop() {
        //This value would probably be stored elsewhere.
        final double GAME_HERTZ = 30.0;
        //Calculate how many ns each frame should take for our target game hertz.
        final double TIME_BETWEEN_UPDATES = 1000000000 / GAME_HERTZ;
        //At the very most we will update the game this many times before a new render.
        //If you're worried about visual hitches more than perfect timing, set this to 1.
        final int MAX_UPDATES_BEFORE_RENDER = 5;
        //We will need the last update time.
        double lastUpdateTime = System.nanoTime();
        //Store the last time we rendered.
        double lastRenderTime = System.nanoTime();

        //If we are able to get as high as this FPS, don't render again.
        final double TARGET_FPS = 60;
        final double TARGET_TIME_BETWEEN_RENDERS = 1000000000 / TARGET_FPS;

        //Simple way of finding FPS.
        int lastSecondTime = (int) (lastUpdateTime / 1000000000);
        //store the time we started this will be used for updating map and charcter animations
        long currTime = System.currentTimeMillis();

        while (running.get()) {

            if (!paused.get()) {

                double now = System.nanoTime();
                long elapsedTime = System.currentTimeMillis() - currTime;
                currTime += elapsedTime;
                int updateCount = 0;

                //Do as many game updates as we need to, potentially playing catchup.
                while (now - lastUpdateTime > TIME_BETWEEN_UPDATES && updateCount < MAX_UPDATES_BEFORE_RENDER) {

                    updateGame(elapsedTime);//Update the entity movements and collision checks etc (all has to do with updating the games status i.e  call move() on Enitites)

                    lastUpdateTime += TIME_BETWEEN_UPDATES;
                    updateCount++;
                }

                //If for some reason an update takes forever, we don't want to do an insane number of catchups.
                //If you were doing some sort of game that needed to keep EXACT time, you would get rid of this.
                if (now - lastUpdateTime > TIME_BETWEEN_UPDATES) {
                    lastUpdateTime = now - TIME_BETWEEN_UPDATES;
                }

                drawGame();//draw the game by invokeing repaint (which will call paintComponent) on this JPanel

                lastRenderTime = now;

                //Update the frames we got.
                int thisSecond = (int) (lastUpdateTime / 1000000000);

                if (thisSecond > lastSecondTime) {
                    //System.out.println("NEW SECOND " + thisSecond + " " + frameCount);
                    fps = frameCount;
                    frameCount = 0;
                    lastSecondTime = thisSecond;
                }

                //Yield until it has been at least the target time between renders. This saves the CPU from hogging.
                while (now - lastRenderTime < TARGET_TIME_BETWEEN_RENDERS && now - lastUpdateTime < TIME_BETWEEN_UPDATES) {
                    //allow the threading system to play threads that are waiting to run.
                    Thread.yield();

                    //This stops the app from consuming all your CPU. It makes this slightly less accurate, but is worth it.
                    //You can remove this line and it will still work (better), your CPU just climbs on certain OSes.
                    //FYI on some OS's this can cause pretty bad stuttering. Scroll down and have a look at different peoples' solutions to this.
                    //On my OS(Windows 7 x64 intel i3) it does not allow for time to make enityt etc move thus all stands still
                    try {
                        Thread.sleep(1);
                    } catch (Exception e) {
                    }
                    now = System.nanoTime();
                }
            }
        }
        fps = 0;//no more running set fps to 0
    }

    private void drawGame() {
        //Both revalidate and repaint are thread-safe — you need not invoke them from the event-dispatching thread. http://docs.oracle.com/javase/tutorial/uiswing/layout/howLayoutWorks.html
        repaint();
    }

    private void updateGame(long elapsedTime) {
        updateEntityMovements(elapsedTime);
        checkForCollisions();
    }

    private void checkForCollisions() {
        if (entities.get(0).intersects(entities.get(2)) || entities.get(1).intersects(entities.get(2))) {
            if (entities.get(2).LEFT) {
                entities.get(2).RIGHT = true;
                entities.get(2).LEFT = false;
            } else {
                entities.get(2).LEFT = true;
                entities.get(2).RIGHT = false;

            }
            System.out.println("Intersecting");
        } /*
         //This is best used when images have transparent and non-transparent pixels (only detects pixel collisions of non-transparent pixels)
         if (entities.get(0).checkPerPixelCollision(entities.get(2)) | entities.get(1).checkPerPixelCollision(entities.get(2))) {
         if (entities.get(2).LEFT) {
         entities.get(2).RIGHT = true;
         entities.get(2).LEFT = false;
         } else {
         entities.get(2).LEFT = true;
         entities.get(2).RIGHT = false;

         }
         System.out.println("Intersecting");
         }
         */
    }

    private void updateEntityMovements(long elapsedTime) {
        for (Entity e : entities) {
            e.update(elapsedTime);
            e.move();
        }
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2d = (Graphics2D) grphcs;

        applyRenderHints(g2d);
        drawBackground(g2d);
        drawEntitiesToScreen(g2d);
        drawFpsCounter(g2d);

        frameCount++;
    }

    public static void applyRenderHints(Graphics2D g2d) {
        g2d.setRenderingHints(textRenderHints);
        g2d.setRenderingHints(imageRenderHints);
        g2d.setRenderingHints(colorRenderHints);
        g2d.setRenderingHints(interpolationRenderHints);
        g2d.setRenderingHints(renderHints);
    }

    private void drawEntitiesToScreen(Graphics2D g2d) {
        for (Entity e : entities) {
            if (e.isVisible()) {
                g2d.drawImage(e.getCurrentImage(), (int) e.getX(), (int) e.getY(), null);
            }
        }
    }

    private void drawFpsCounter(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        g2d.drawString("FPS: " + fps, 5, 10);
    }

    private void drawBackground(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        //thanks to trashgod for lovely testing background :) http://stackoverflow.com/questions/3256269/jtextfields-on-top-of-active-drawing-on-jpanel-threading-problems/3256941#3256941
        g2d.setColor(Color.BLACK);
        for (int i = 0; i < 128; i++) {
            g2d.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));//random color
            g2d.drawLine(getWidth() / 2, getHeight() / 2, random.nextInt(getWidth()), random.nextInt(getHeight()));
        }
    }
}