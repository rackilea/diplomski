import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class BouncingBallApp extends JFrame {

    public static void main(String[] args) {
        // Container container;
        BouncingBallApp bouncingBalls = new BouncingBallApp();
        bouncingBalls.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // container = new Container();
        BouncingBallPanel BBP = new BouncingBallPanel();
        // container.add(BBP);
        bouncingBalls.addMouseListener(BBP);
        // addMouseListener;
        bouncingBalls.setBackground(Color.WHITE);
        bouncingBalls.setSize(400, 300);

        BBP.setSize(400, 300);
        BBP.setLayout(null);
        bouncingBalls.setContentPane(BBP);

        /*
         * JTextField jtf = new JTextField(); BBP.add(jtf); jtf.setSize(100,
         * 20);
         */

        bouncingBalls.setVisible(true);

    }// end of main method
}// end of BouncingBallApp

class BouncingBallPanel extends JPanel implements MouseListener {
    private Ball[] ballArray = new Ball[20];
    private int ballCount = 0;

    public void mouseClicked(MouseEvent e) {

        ballArray[ballCount] = new Ball();
        ballCount++;
        if (ballCount == 1) {

            final Runnable updateGraphics = new Runnable() {
                public void run() {
                    for (int i = 0; i < ballArray.length; i++) {
                        if (ballArray[i] != null) {
                            ballArray[i].move();
                        }
                    }
                    repaint();
                }
            };

            Runnable animation = new Runnable() {
                public void run() {
                    while (true) {
                        try {
                            EventQueue.invokeLater(updateGraphics);
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            return;
                        }
                    }
                }
            };

            new Thread(animation).start();

        }

    }

    // empty interface methods
    public void mouseExited(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {

    }

    public void paintComponent(Graphics g) {
        // super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (int i = 0; i < ballArray.length; i++) { if (ballArray[i] !=
            null) { System.out.println(" ball " + i + " , " +
                    ballArray[i].getColor() + " , " + ballArray[i].getX() + " , " +
                    ballArray[i].getY() + " , " + ballArray[i].getDiameter());
            g2d.setColor(ballArray[i].getColor());
            g2d.fillRect((int)ballArray[i].getX(), (int)ballArray[i].getY(),
                    (int)ballArray[i].getDiameter(), (int)ballArray[i].getDiameter()); }
        }// end of for loop


    }

}// end of BouncingBallPanel

class Ball {
    private double x;
    private double y;
    private double deltaX;
    private double deltaY;
    private double diameter;
    private Color color;

    Random random = new Random();

    public Ball() {
        x = random.nextInt(400);
        y = random.nextInt(300);
        deltaX = 2;
        deltaY = 2;
        diameter = 10;
        color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }// end of constructor

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getDiameter() {
        return diameter;
    }

    public Color getColor() {
        return color;
    }

    public void move() {
        x += deltaX;
        y += deltaY;

        if (x < 0) {
            x = 0;
            deltaX = -deltaX;
        }

        else if (x > 400) {
            x = 400;
            deltaX = -deltaX;
        }

        if (y < 0) {
            y = 0;
            deltaY = -deltaY;
        }

        else if (y > 300) {
            y = 300;
            deltaY = -deltaY;
        }

    }// end of method move

}// end of ball