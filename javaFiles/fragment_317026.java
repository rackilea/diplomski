import java.awt.*;
import java.awt.Container;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;

public class DragListener extends MouseInputAdapter
{
    private Point location;
    private MouseEvent pressed;
    private MouseEvent dragged;
    private MouseEvent dropped;
    private LayoutManager layout;

    @Override
    public void mousePressed(MouseEvent me)
    {
        pressed = me;
        Component component = me.getComponent();
        Container parent = component.getParent();
        parent.setPreferredSize(parent.getPreferredSize());
        layout = parent.getLayout();
        parent.setLayout(null);
    }

    @Override
    public void mouseDragged(MouseEvent me)
    {
        dragged = me;
        Component component = dragged.getComponent();
        Container parent = component.getParent();
        Container superParent = parent.getParent();

        if(superParent instanceof JViewport)
        {
            JViewport vp = (JViewport)superParent;
            Rectangle vpb = vp.getBounds();
            Point pt = MouseInfo.getPointerInfo().getLocation();
            SwingUtilities.convertPointFromScreen(pt, vp);

            if(!vpb.contains(pt))
            {
                int yDiff = (pt.y < vpb.y ) ? pt.y : pt.y - vpb.height;
                vpb.translate(0, yDiff);
                vp.scrollRectToVisible(vpb);
            }
        }

        location = component.getLocation(location);
        int x = location.x - pressed.getX() + me.getX();
        int y = location.y - pressed.getY() + me.getY();
        component.setLocation(x, y);
    }

    // Mouse release omitted
    @Override
    public void mouseReleased(MouseEvent me)
    {
        Component component = me.getComponent();
        Container parent = component.getParent();
        parent.setPreferredSize( null );
        parent.setLayout(layout);
        parent.validate();
        parent.repaint();
    }
}