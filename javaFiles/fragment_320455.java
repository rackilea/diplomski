import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Game extends JPanel {
    /*
     * Now x and y are instance variables,
     * whose values you can change at each
     * MouseMove Event, and call repaint()
     * to see the effects
     */

    private int x;
    private int y;
    private MouseAdapter mouseActions =
        new MouseAdapter() {
        @Override
        public void mouseMoved(MouseEvent me) {
            /*
             * Now as the Mouse moves, we simply
             * updating the instance variables,
             * i.e. x and y to the new values
             * of the Mouse Location and calling
             * repaint() to draw the rectangle.
             * Since this class (Game) extends JPanel,
             * hence all the functions of the JPanel
             * belongs to this class, hence like
             * as we call any other method of this
             * class, without using the object,
             * we can call repaint, likewise.
             */
            x = me.getX();
            y = me.getY();
            repaint();
        }
    };

    /*
     * This JPanel panel is unnecessary in 
     * this case, since the class itself 
     * extends JPanel, hence you can use
     * this (keyword) to access the instance
     */
    //JPanel panel;
    // Not needed for this case.
    //JButton button2;
    //JButton button;
    public void game() {

        JFrame frame = new JFrame("Game");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        addMouseMotionListener(mouseActions);
        /*
         * Here this means the instance
         * of the current class
         */
        frame.add(this);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /*
     * While overriding methods of the 
     * super class, try to keep the 
     * ACCESS SPECIFIER, as close to
     * the original thingy as possible
     * In this case, it's protected
     * and not public
     */
    @Override
    protected void paintComponent(Graphics g) {

        /*
         * Do not perform calculation in this method
         * atleast.
         */
        super.paintComponent(g);
        g.fillRect(x, y, 100, 100);
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new Game().game();
            }
        };
        EventQueue.invokeLater(runnable);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }
}