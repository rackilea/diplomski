import java.awt.*;
import java.awt.Container;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;

public class DragListener extends MouseInputAdapter
{
    private Point location;
    private MouseEvent pressed;
    private MouseEvent dragged;
    private MouseEvent dropped;
    private LayoutManager layout;
    private Rectangle originalBounds;
    private int originalZOrder;

    @Override
    public void mousePressed(MouseEvent me)
    {
        pressed = me;
        Component component = me.getComponent();
        Container parent = component.getParent();
        originalBounds = component.getBounds();
        originalZOrder = parent.getComponentZOrder(component);
        parent.setPreferredSize(parent.getPreferredSize());
        layout = parent.getLayout();
        parent.setLayout(null);
        parent.setComponentZOrder(component, 0);
    }

    @Override
    public void mouseDragged(MouseEvent me)
    {
        JComponent source = (JComponent) me.getComponent();
        JComponent parent = (JComponent) source.getParent();

        Point p = me.getPoint();
        p = SwingUtilities.convertPoint(source, p, parent);

        Rectangle bounds = source.getBounds();
        bounds.setLocation(p);

        bounds.x -= pressed.getX();
        bounds.y -= pressed.getY();
        source.setLocation(0, bounds.y);
        parent.scrollRectToVisible(bounds);
    }

    @Override
    public void mouseReleased(MouseEvent me)
    {
        boolean moved = false;
        Component component = me.getComponent();
        Container parent = component.getParent();
        Point location = component.getLocation();

        if (location.y < 0)
        {
            parent.add(component, 0);
            moved = true;
        }
        else
        {
            for (int i = 0; i < parent.getComponentCount(); i++)
            {
                Component c = parent.getComponent(i);
                Rectangle bounds = c.getBounds();

                if (c == component)
                    bounds = originalBounds;

                //  Component is released in the space originally occupied
                //  by the component or over an existing component

                if (bounds.contains(0, location.y))
                {
                    if (c == component)
                    {
                        parent.setComponentZOrder(component, originalZOrder);
                    }
                    else
                    {
                        parent.add(component, i);
                    }

                    moved = true;
                    break;
                }
            }
        }

        //  Component is positioned below all components in the container

        if (!moved)
        {
            parent.add(component, parent.getComponentCount() - 1);
        }

        //  Restore layout manager

        parent.setPreferredSize( null );
        parent.setLayout(layout);
        parent.validate();
        parent.repaint();
        component.requestFocusInWindow();
    }

    private static void createAndShowGUI()
    {
        JPanel panel = new JPanel( new GridLayout(0, 1) );
        DragListener drag = new DragListener();

        for (int i = 0; i <10; i++)
        {
            JButton button = new JButton("" + i);
            button.setFont(new java.awt.Font("Tahoma", 1, 48));
            button.setForeground(new java.awt.Color(255, 0, 0));
            button.addMouseListener(drag);
            button.addMouseMotionListener(drag);
            panel.add( button );
        }

        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new JScrollPane(panel) );
        frame.setLocationByPlatform( true );
        frame.setSize(200, 400);
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
    }
}