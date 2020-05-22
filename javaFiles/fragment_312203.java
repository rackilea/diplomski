import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashSet;
public class GamePanel extends JPanel {

    // ENUM     
    public enum HorizontalMovement {
        NONE,
        LEFT,
        RIGHT
    }

    // CONSTANTS    
    private static final int WIDTH = 600;
    private static final int HEIGHT = 500;
    private static final int PADDLE_Y = 475;
    private static final int PADDLE_W = 80;
    private static final int PADDLE_H = 20;
    private static final int PADDLE_ARC = 15;
    private HashSet<HorizontalMovement> movements = new HashSet<HorizontalMovement>();

    // PROPERTIES   
    int x = 0;
    private Timer timer;

    // CONSTRUCTOR  
    public GamePanel() {

        setSize(WIDTH, HEIGHT);
        setBackground(new Color(240, 255, 255));

        // right pressed

        KeyStroke ks1 = KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false);

        InputMap im1 = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am1 = getActionMap();

        im1.put(ks1, "right.pressed");
        am1.put("right.pressed", new MoveHorizontialAction(true,HorizontalMovement.RIGHT));

        // right released
        KeyStroke ks2 = KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true);
        InputMap im2 = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am2 = getActionMap();

        im2.put(ks2, "right.relesed");
        am2.put("right.relesed", new MoveHorizontialAction(false,HorizontalMovement.RIGHT));

        // left pressed

        KeyStroke ks3 = KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false);

        InputMap im3 = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am3 = getActionMap();

        im3.put(ks3, "left.pressed");
        am3.put("left.pressed", new MoveHorizontialAction(true,HorizontalMovement.LEFT));

        // left released

        KeyStroke ks4 = KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true);

        InputMap im4 = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am4 = getActionMap();

        im4.put(ks4, "left.relesed");
        am4.put("left.relesed", new MoveHorizontialAction(false,HorizontalMovement.LEFT));

        // each 15 ms       
        timer = new Timer(15, new TimeListener());
        timer.start();

    }

    // PADDLE 
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(new Color(201, 51, 51));
        g.fillRoundRect(x, PADDLE_Y, PADDLE_W, PADDLE_H, PADDLE_ARC, PADDLE_ARC);   
    }

    // Time Listener

    protected class TimeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if ( movements.contains(HorizontalMovement.RIGHT) )
                x = x + 2;

            if ( movements.contains(HorizontalMovement.LEFT) )
                x = x - 2;

            if ( x < 0 ) 
                x = 0;
            else if ( x > 520 ) 
                x = 520;

            repaint();
        }

    }

    // ACTION FOR ActionMap
    protected class MoveHorizontialAction extends AbstractAction {

        private HorizontalMovement movement;
        private boolean add=true;
        public MoveHorizontialAction(boolean add,HorizontalMovement movement) {
            this.movement = movement;
            this.add = add;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(add){
                //System.out.println("Add: "+movement.name());
                movements.add(movement);
            }else{
                //System.out.println("Rem: "+movement.name());
                movements.remove(movement);
            }
        }
    }   
}