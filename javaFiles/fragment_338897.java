import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DragBallPanel extends JPanel implements MouseListener, MouseMotionListener
{

    private static final int BALL_DIAMETER = 40; // Diameter of ball

    private int screen_size_x = 300;
    private int screen_size_y = 300;
    private int ground_lvl = screen_size_y - 15;

    private int _ballX     = ground_lvl/2;
    private int _ballY     = ground_lvl - BALL_DIAMETER;
    private final double GRAVITY = -9.8;
    private double velocity;
    private static final double TERM_VEL = 100;

    private int _dragFromX = 0;    // pressed this far inside ball's
    private int _dragFromY = 0;    // bounding box.

    /** true means mouse was pressed in ball and still in panel.*/
    private boolean _canDrag  = false;

    public DragBallPanel()
    {
        setPreferredSize(new Dimension(screen_size_x, screen_size_y));
        setBackground(Color.darkGray);
        setForeground(Color.darkGray);

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public void paintComponent(Graphics g)
     {
        super.paintComponent(g);   // Required for background.
          g.setColor (Color.green);
          g.fillRect (0, 280, 400, 50 );
          g.setColor (Color.black);
        g.fillOval(_ballX, _ballY, BALL_DIAMETER, BALL_DIAMETER);

    }

    public void mousePressed(MouseEvent e)
    {
        int x = e.getX();   // Save the x coord of the click
        int y = e.getY();   // Save the y coord of the click

        if (x >= _ballX && x <= (_ballX + BALL_DIAMETER)
                && y >= _ballY && y <= (_ballY + BALL_DIAMETER)) {
            _canDrag = true;
            _dragFromX = x - _ballX;  // how far from left
            _dragFromY = y - _ballY;  // how far from top
        } else {
            _canDrag = false;
        }
    }

    //========= mouseDragged =================
    /** Set x,y  to mouse position and repaint. */
    public void mouseDragged(MouseEvent e)
    {
        if (_canDrag) {   // True only if button was pressed inside ball.
            //--- Ball pos from mouse and original click displacement
            _ballX = e.getX() - _dragFromX;
            _ballY = e.getY() - _dragFromY;

            //--- Don't move the ball off the screen sides
            _ballX = Math.max(_ballX, 0);
            _ballX = Math.min(_ballX, getWidth() - BALL_DIAMETER);

            //--- Don't move the ball off top or bottom
            _ballY = Math.max(_ballY, 0);
            _ballY = Math.min(_ballY, getHeight() - BALL_DIAMETER);

            this.repaint(); // Repaint because position changed.
        }
    }

    //====================================================== method mouseExited
    /** Turn off dragging if mouse exits panel. */
    public void mouseExited(MouseEvent e)
     {
         System.out.println("Exited: " + e);
        //_canDrag = false;
        runGravity();
        /*  while(_ballY < ground_lvl)
          {
             simulateGravity();
          }*/
    }

    Timer timer;
    ActionListener animate;

    public void runGravity() {
        if (animate==null) {
            animate = new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    System.out.println("Ground: " + (_ballY-ground_lvl));
                    if (_ballY > ground_lvl) {
                        timer.stop();
                    } else {
                        simulateGravity();
                    }
                }
            };
            timer = new Timer(100,animate);
        }
        timer.start();
    }

     public void simulateGravity()
     {
         System.out.println("_canDrag: " + _canDrag);
         if(_canDrag)
         {

             velocity = velocity + GRAVITY;

           if (velocity > TERM_VEL)
             {
                velocity = TERM_VEL;
             }

            if (_ballY >= ground_lvl - BALL_DIAMETER)
            {
                //We have hit the "ground", so bounce back up. Reverse
                //the speed and divide by 4 to make it slower on bouncing.
                //Just change 4 to 2 or something to make it faster.
               velocity = velocity/4;
            }
            _ballY += velocity;
             //this.revalidate();
             this.repaint();
         }
    }

    public void mouseMoved   (MouseEvent e){}
    public void mouseEntered (MouseEvent e){}
    public void mouseClicked (MouseEvent e){}
    public void mouseReleased(MouseEvent e){}

    public static void main(String[] args) {
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                DragBallPanel dbp = new DragBallPanel();
                JOptionPane.showMessageDialog(null, dbp);
            }
        });
    }
}