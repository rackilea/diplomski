import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class RotateRectangleRound extends JFrame implements KeyListener {
    private static final long serialVersionUID = 9085168127541601308L;

    private Rectangle stableRect;
    private int cw = 400, ch = 400;
    private boolean collision;
    private int spx = 0, spy = 0;

    private double radius = 120;
    private double angleX = 0, angleY = 0;
    private int rotatingVal = 0;
    private Line2D line;
    private LineIterator iterator;
    private Point currentPoint;
    private Point2D tp;

    private static BasicStroke spinningStroke = new BasicStroke(8);
    private static BasicStroke basicStroke = new BasicStroke(1);

    private MyPanel panel;

    private static boolean startWorker;
    private SwingWorker<Void, Void> swingWorker;

    public RotateRectangleRound() {
        init();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RotateRectangleRound();
            }
        });
    }

    private void init() {

        this.setTitle("Rotate Rectangle - Paused");
        this.getContentPane().setLayout(new GridLayout(1, 1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(400, 200, 400, 400);

        this.setLayout(new GridLayout(1, 1));

        this.addKeyListener(this);
        this.setVisible(true);

        // getting the window width & height insets explicitly
        cw = this.getContentPane().getWidth();
        ch = this.getContentPane().getHeight();

        // setting the stableRect and movableRect to between of screen except insets
        stableRect = new Rectangle(20, 20, 40, 40);
        angleX = 192;
        angleY = 300;

        this.panel = new MyPanel();
        this.add(panel);

    }

    @Override
    public void keyTyped(KeyEvent evt) {}

    public void keyPressed(KeyEvent evt) {
        int key = evt.getKeyCode();

        if (key == KeyEvent.VK_DOWN) {
            spy = 4;
            moveStableRectangle();
        } else if (key == KeyEvent.VK_UP) {
            spy = -4;
            moveStableRectangle();
        } else if (key == KeyEvent.VK_RIGHT) {
            spx = 4;
            moveStableRectangle();
        } else if (key == KeyEvent.VK_LEFT) {
            spx = -4;
            moveStableRectangle();
        }

        if (key == KeyEvent.VK_SPACE) {
            startWorker = (!startWorker);
            if (startWorker) {
                this.setTitle("Rotate Rectangle");
                collision = false;
                startRotatingFromPoint();
            }else {
                this.setTitle("Rotate Rectangle - Paused");
            }
        }

    }

    private void moveStableRectangle() {
        stableRect.x += spx;
        stableRect.y += spy;
        repaint();
    }

    public void keyReleased(KeyEvent evt) {
        spx = 0;
        spy = 0;
    }

    private void startRotatingFromPoint() {
        swingWorker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                while (startWorker) {
                    try {
                        if (rotatingVal == 360)
                            rotatingVal = 0;

                        // first getting the angle x, y value for radius 100,
                        // second adding the half of width & height to rotate
                        // between screen accordingly with that w & h value
                        angleX = (Math.sin(Math.toRadians((double) rotatingVal)) * radius) + (cw / 2);
                        angleY = (Math.cos(Math.toRadians((double) rotatingVal++)) * radius) + (ch / 2);

                        // calculating collision
                        collision();
                        // requesting frame repainting
                        repaint();

                        Thread.sleep(10);
                    } catch (InterruptedException iex) {
                        iex.printStackTrace();
                    }
                }

                return null;
            }
        };

        swingWorker.execute();
    }

    public void collision() {
        if (detectCollision()) {
            collision = true;
            startWorker = false;
            this.setTitle("Rotate Rectangle - Hitted");
        } else {
            collision = false;
        }
    }

    private boolean detectCollision() {
        boolean flag = false;

        if(angleX < (cw/2))
            line = new Line2D.Double(angleX, angleY, cw / 2, ch / 2);
        else
            line = new Line2D.Double(cw / 2, ch / 2, angleX, angleY);

        //creating a iterator by use of Bresenham's algorithm
        iterator = new LineIterator(line);

        looperFor:
        for (Iterator<Point2D> it = iterator; it.hasNext();) {
            //getting Point2D Object of Point Iterator
            tp = it.next();
            currentPoint = new Point((int) tp.getX(), (int) tp.getY());

            if (stableRect.contains(currentPoint)) {
                flag = true;
                break looperFor;
            }
        }

        //returning the detected collision flag true or false
        return flag;
    }

    class MyPanel extends JPanel {
        private static final long serialVersionUID = 1L;

        @Override
        public void paintComponent(Graphics gr) {
            Graphics2D g = (Graphics2D) gr;

            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

            g.setStroke(basicStroke);

            if (collision)
                g.setColor(Color.RED);

            g.fillRect(stableRect.x, stableRect.y, stableRect.width, stableRect.height);
            g.setStroke(spinningStroke);
            g.drawLine(cw / 2, ch / 2, (int) angleX, (int) angleY);
        }
    }

}