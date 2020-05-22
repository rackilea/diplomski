import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class BasicComponentMover extends MouseInputAdapter
{
    /*
    **  A class that allows you to drag a component around a panel.
    **  Optionally you can specify a "parent" component, in which case
    **  the MouseEvents will be converted to be relative to this component
    **  which will then be dragged. This will allow you to drag a JFrame by
    **  dragging a component that has been added to the frame.
    */
    private Component parent;
    private Component destination;
    private Point pressed;

    BasicComponentMover() {}
    {
    }

    BasicComponentMover(Component parent)
    {
        this.parent = parent;
    }

    @Override
    public void mousePressed(MouseEvent me)
    {
        destination = (parent == null) ? me.getComponent() : parent;
        pressed = SwingUtilities.convertPoint(me.getComponent(), me.getPoint(), destination);
    }

    @Override
    public void mouseDragged(MouseEvent me)
    {
        Point location = destination.getLocation();
        Point drag = SwingUtilities.convertPoint(me.getComponent(), me.getPoint(), destination);
        int x = (int)(location.x - pressed.getX() + drag.getX());
        int y = (int)(location.y - pressed.getY() + drag.getY());
        destination.setLocation(x, y);
    }

    private static void createAndShowGUI()
    {
        JPanel background = new JPanel(null);
        background.setPreferredSize(new Dimension(300, 300));
        background.setSize(background.getPreferredSize());
        background.setBackground(Color.RED);

        JPanel foreground = new JPanel(null);
        foreground.setPreferredSize(new Dimension(50, 50));
        foreground.setSize(foreground.getPreferredSize());
        foreground.setBackground(Color.BLUE);
        background.add(foreground);

        JFrame frame = new JFrame("BasicComponentMover");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.add(background);
        frame.setSize(500, 500);
        frame.setLocationByPlatform( true );
        frame.setVisible( true );

        //  Drag frame by dragging the red background panel

        BasicComponentMover bcm1 = new BasicComponentMover(frame);
        background.addMouseListener(bcm1);
        background.addMouseMotionListener(bcm1);

        // Drag the blue forground component around the red background

        BasicComponentMover bcm2 = new BasicComponentMover();
        foreground.addMouseListener(bcm2);
        foreground.addMouseMotionListener(bcm2);

        //  Or, drage the background around the frame

        BasicComponentMover bcm3 = new BasicComponentMover(background);
//      foreground.addMouseListener(bcm3);
//      foreground.addMouseMotionListener(bcm3);
    }

    public static void main(String[] args) throws Exception
    {
        EventQueue.invokeLater( () -> createAndShowGUI() );
/*
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
*/
    }
}