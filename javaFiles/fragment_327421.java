import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class Game extends Applet implements Runnable, KeyListener {

    private final int GAMEBOARD_WIDTH = 400;

    // setting up double buffering.
    private Graphics graphics;
    private Image img;
    private Thread thread;
    private Snake snake;

    public void init() {
        // setting the size of our Applet
        this.resize(GAMEBOARD_WIDTH, GAMEBOARD_WIDTH);
        // we gonna create the image just the same size as our applet.
        img = createImage(GAMEBOARD_WIDTH, GAMEBOARD_WIDTH);
        // this represents our offscreen image that we will draw
        graphics = img.getGraphics();
        this.addKeyListener(this);
        snake = new Snake();
        thread = new Thread(this);
        thread.start();
    }

    public void paint(Graphics g) {
        // Setting the background of our applet to black
        graphics.setColor(Color.BLACK);
        // Fill rectangle 0 , 0 (starts from) for top left corner and then 400,400 to
        // fill our entire background to black
        graphics.fillRect(0, 0, GAMEBOARD_WIDTH, GAMEBOARD_WIDTH);
        snake.draw(graphics);
        // painting the entire image
        g.drawImage(img, 0, 0, null);
    }

    // Update will call on Paint(g)
    public void update(Graphics g) {
        paint(g);
    }

    // Repaint will call on Paint(g)
    public void repaint(Graphics g) {
        paint(g);
    }

    public void run() {
        // infinite loop
        for (;;) {
            snake.move();
            // drawing snake
            this.repaint();
            // Creating a time delay
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void keyTyped(KeyEvent keyEvent) {

    }

    public void keyPressed(KeyEvent keyEvent) {

        int keyCode = keyEvent.getKeyCode();

        if (!snake.isMoving()) {
            // this will allow the snake to start moving, but will disable LEFT for just the
            // 1st move
            if (matchKey(keyCode, KeyEvent.VK_UP, KeyEvent.VK_RIGHT, KeyEvent.VK_DOWN)) {
                snake.setIsMoving(true);
            }
        }

        // setting up Key mapping so when the user presses UP,RIGHT,DOWN,LEFT. the Snake
        // will move accordingly
        if (matchKey(keyCode, KeyEvent.VK_UP)) {
            snake.setDirection(Direction.UP);
        }
        if (matchKey(keyCode, KeyEvent.VK_RIGHT)) {
            snake.setDirection(Direction.RIGHT);
        }
        if (matchKey(keyCode, KeyEvent.VK_DOWN)) {
            snake.setDirection(Direction.DOWN);
        }
        if (matchKey(keyCode, KeyEvent.VK_LEFT)) {
            snake.setDirection(Direction.LEFT);
        }

    }

    // return true if targetKey contains the provided keyCode
    private boolean matchKey(int keyCode, int... targetKey) {
        return Arrays.stream(targetKey).anyMatch(i -> i == keyCode);
    }

    public void keyReleased(KeyEvent keyEvent) {

    }
}