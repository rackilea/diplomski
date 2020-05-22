import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TPanel extends JPanel implements KeyListener {

    boolean towerA;
    boolean towerB;
    boolean towerC;

    public TPanel() {
        super();
        setSize(600, 600);
        // for testing
        setBackground(Color.BLACK);
        addKeyListener(this);
        // A component must BE focusable before it can hop to accept the focus.
        setFocusable(true); 
        // create an animation listener
        ActionListener animationListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        };
        // create and start an animation timer
        Timer timer = new Timer(200, animationListener);
        timer.start();
        requestFocus();
    }

    public void keyTyped(KeyEvent e) {
    }

    @Override
    /* I've never bothered to find out what addNotify() method is for.
    Inadvisable to use it to request the focus! 
    public void addNotify() {
        requestFocus();
    } */

    /* For any JComponent, we should override the paintComponent(Graphics)
    method rather than the paint(Graphics) method. */
    public void paintComponent(Graphics g) {
        /* 1st thing should be done in any overridden paint method is to
        call the super method. */
        super.paintComponent(g);
        //addNotify();
        if (towerA == true) {
            g.setColor(Color.GREEN);
            g.fillRect(20, getHeight(), 40, 100);
        } else {
            g.setColor(Color.RED);
            g.fillRect(20, 0, 40, 100);
        }
        if (towerB == true) {
            g.setColor(Color.GREEN);
            g.fillRect(100, 0, 40, 100);
        } else {
            g.setColor(Color.RED);
            g.fillRect(100, 0, 40, 100);
        }
        if (towerC == true) {
            g.setColor(Color.GREEN);
            g.fillRect(180, 0, 40, 100);
        } else {
            g.setColor(Color.RED);
            g.fillRect(180, 0, 40, 100);
        }
        /* As mentioned in comment, this will cause an infinite loop & block
        the EDT! Use a Swing Timer for animation. */
        // repaint(); 
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // for testing
        System.out.println("e: " + e);
        addNotify();
        if (e.getKeyChar() == '1') {
            towerA = true;
        }
        if (e.getKeyChar() == '2') {
            towerB = true;

        }
        if (e.getKeyChar() == '3') {
            towerC = true;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        new TFrame("Frame");
    }
}

class TFrame extends JFrame implements java.awt.event.KeyListener {

    public TFrame(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        addKeyListener(this);

        TPanel p = new TPanel();
        Insets frameInsets = getInsets();

        int frameWidth = p.getWidth() + (frameInsets.left + frameInsets.right);
        int frameHeight = p.getHeight() + (frameInsets.top + frameInsets.bottom);

        setPreferredSize(new Dimension(frameWidth, frameHeight));

        // Java GUIs were designed to work with layouts. Use them! 
        // setLayout(null);
        add(p);
        pack();
        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}