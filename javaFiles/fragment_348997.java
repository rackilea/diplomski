package bradleyross.experiments;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.InvocationTargetException;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
/**
 * This Swing demo creates a JPanel component and randomly 
 * moves a red dot within the panel when triggered by a
 * timer.
 * 
 * @author Bradley Ross
 *
 */
public class SwingTimer implements Runnable{
    protected JFrame mainFrame;
    protected FlowLayout layout;
    protected MyPanel panel;
    protected int xPos = 0;
    protected int yPos = 0;
    protected Random random = new Random();
    protected Timer timer = new Timer();
    public void run() {
        buildFrame();
    }
    /**
     * Action listener for this application.
     * @author Bradley Ross
     *
     */
    protected class Listener1 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.out.println("Action " + e.getActionCommand());
        }

    }
    /**
     * Key listener for this application.
     * @author Bradley Ross
     *
     */
    protected class Listener2 implements KeyListener {
        /** 
         * Action when key event is detected.
         *  @param e key event
         */
        public void keyTyped(KeyEvent e) {
            System.out.println("Keystroke received " + e.getKeyChar());
        }
        public void keyPressed(KeyEvent e) { ; }
        public void keyReleased(KeyEvent e) { ; }

    }
    /**
     * This subclass of JPanel repaints the
     * the dot using {@link SwingTimer#xPos} and 
     * {@link SwingTimer#yPos}.
     * 
     * @author Bradley Ross
     *
     */
    @SuppressWarnings("serial")
    public class MyPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.fillOval(xPos,  yPos, 5, 5);
        }
    }
    /**
     * Executed each time the timer triggers an event.
     * 
     * <p>It randomly repositions the dot within the
     *    panel.</p>
     * @author Bradley Ross
     *
     */
    public class Motion extends TimerTask {
        public void run() {
            xPos = random.nextInt(300);
            yPos = random.nextInt(300);
            panel.repaint();
        }
    }
    public void buildFrame() {
        xPos = random.nextInt(300);
        yPos = random.nextInt(300);
        KeyListener listener2 = new Listener2();
        ActionListener listener1 = new Listener1();
        mainFrame = new JFrame();
        layout = new FlowLayout(FlowLayout.LEADING);
        mainFrame.setLayout(layout);
        mainFrame.addKeyListener(listener2);
        JButton first = new JButton("First");
        first.setActionCommand("first");
        first.addActionListener(listener1);
        first.addKeyListener(listener2);
        first.setFocusable(false);
        mainFrame.add(first);
        mainFrame.setFocusable(true);
        panel = new MyPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.setPreferredSize(new Dimension(300,300));
        panel.setForeground(Color.red);
        panel.addKeyListener(listener2);
        panel.repaint();
        timer.scheduleAtFixedRate(new Motion(), 0  , 2000);
        mainFrame.add(panel);
        mainFrame.setSize(500, 500);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setVisible(true);
    }
    /**
     * Main driver.
     * @param args not used in this example
     */
    public static void main(String[] args) {
        try {
            SwingUtilities.invokeAndWait(new SwingTimer());
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}