import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class FullScreenRenderWithListener implements Runnable
{

    private JFrame frame;
    private World world;

    public static void main ( String[] args )
    {
        FullScreenRenderWithListener main = new FullScreenRenderWithListener ();
        SwingUtilities.invokeLater ( main );
    }

    public void run ()
    {
        initWindow ();
        setupWorld ();
        frame.setIgnoreRepaint ( true );
        frame.pack ();
        frame.createBufferStrategy ( 2 );
        frame.setVisible ( true );
        world.startActive ( frame.getBufferStrategy () );
    }

    private void initWindow ()
    {
        frame = new JFrame ();
        frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        frame.setLocationByPlatform ( true );
    }

    private void setupWorld ()
    {
        world = new World ();
        frame.add ( world );
        frame.setFocusable ( true );
        world.setFocusable ( true );
    }
}

class World extends JPanel
{

    private static final int FRAMES_PER_SEC = 10;
    private static final int MILL_IN_SEC = 1000;
    private static final int TICK_LENGTH = MILL_IN_SEC / FRAMES_PER_SEC;
    private BufferStrategy strategy;
    //
    private static final String PRESSED = "Pressed";
    private static final String RELEASED = "Released";
    private Map < Direction , Boolean > directionMap = new HashMap < Direction , Boolean > ();

    private void sleepUntilEndOfFrame ()
    {
        try
        {
            long used = System.currentTimeMillis () % TICK_LENGTH;
            long left = TICK_LENGTH - used;
            Thread.sleep ( left );
        }
        catch ( InterruptedException e )
        {
            // ... Handle this error
            e.printStackTrace ();
        }
    }

    private void setBindings() {
          int context = JComponent.WHEN_IN_FOCUSED_WINDOW;
          InputMap inputMap = getInputMap(context);
          ActionMap actionMap = getActionMap();

          for (Direction direction : Direction.values()) {
             inputMap.put(KeyStroke.getKeyStroke(direction.getKeyCode(), 0, false), direction.getName() + PRESSED);
             inputMap.put(KeyStroke.getKeyStroke(direction.getKeyCode(), 0, true), direction.getName() + RELEASED);

             // set corresponding actions for the  key presses and releases above
             actionMap.put(direction.getName() + PRESSED, new ArrowKeyAction(true, direction));
             actionMap.put(direction.getName() + RELEASED, new ArrowKeyAction(false, direction));
          }
    }

    public void startActive ( BufferStrategy strategy )
    {
        for ( Direction direction : Direction.values () )
        {
            directionMap.put ( direction , Boolean.FALSE );
        }
        setBindings ();
        //
        this.strategy = strategy;
        setIgnoreRepaint ( true );
        Thread t = new Thread (){
            @Override
            public void run ()
            {
                while ( true )
                {
                    doFrame ();
                }
            }
        };
        t.start ();
    }

    private void doFrame ()
    {
        updateGameState ();
        activeRenderFrame ();
    }

    private void updateGameState ()
    {
        // ..
    }

    private void activeRenderFrame ()
    {
        Graphics2D graphicsContext = (Graphics2D) strategy.getDrawGraphics ();
        paintComponent ( graphicsContext );
        strategy.show ();
        Toolkit.getDefaultToolkit ().sync ();
        graphicsContext.dispose ();
        sleepUntilEndOfFrame ();
    }

    @Override
    public Dimension getPreferredSize ()
    {
        return new Dimension ( 500 , 500 );
    }

    // Have overridden this method because the class
    // also implements passive rendering if active is
    // not supported
    @Override
    public void paintComponent ( Graphics g )
    {
        super.paintComponent ( g );
        // .. drawing code
    }

    private class ArrowKeyAction extends AbstractAction
    {
        private Boolean pressed;
        private Direction direction;

        public ArrowKeyAction ( boolean pressed , Direction direction )
        {
            this.pressed = Boolean.valueOf ( pressed );
            this.direction = direction;
        }

        @Override
        public void actionPerformed ( ActionEvent arg0 )
        {
            directionMap.put ( direction , pressed );
            System.out.println ("Direction: "+ direction + ", State: " + pressed);
        }
    }
}

enum Direction {
   UP("Up", KeyEvent.VK_UP, new Point(0, -1)),
   DOWN("Down", KeyEvent.VK_DOWN, new Point(0, 1)),
   LEFT("Left", KeyEvent.VK_LEFT, new Point(-1, 0)),
   Right("Right", KeyEvent.VK_RIGHT, new Point(1, 0));

   private String name;
   private int keyCode;
   private Point vector;
   private Direction(String name, int keyCode, Point vector) {
      this.name = name;
      this.keyCode = keyCode;
      this.vector = vector;
   }
   public String getName() {
      return name;
   }
   public int getKeyCode() {
      return keyCode;
   }
   public Point getVector() {
      return vector;
   }
   @Override
   public String toString() {
      return name;
   }
}