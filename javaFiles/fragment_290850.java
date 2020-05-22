import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class DragLayoutTest
{
    public static void main( String[] args )
    {
        DragListener drag = new DragListener();

        DragLayout dl = new DragLayout();
        dl.setUsePreferredSize(false);

        JPanel panel = new JPanel( dl );
        panel.setBorder( new MatteBorder(10, 10, 10, 10, Color.YELLOW) );

        createLabel(drag, panel, "North", 150, 0);
        createLabel(drag, panel, "West", 0, 100);
        createLabel(drag, panel, "East", 300, 100);
        createLabel(drag, panel, "South", 150, 200);
        createLabel(drag, panel, "Center", 150, 100);

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame( "Drag Layout" );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new JScrollPane(panel) );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible( true );
    }

    public static void createLabel(MouseInputAdapter drag, JPanel panel, String text, int x, int y)
    {
        JLabel label = new JLabel( text );
        label.setOpaque(true);
        label.setBackground( Color.ORANGE );
        label.setLocation(x, y);
        panel.add( label );
        label.addMouseListener( drag );
        label.addMouseMotionListener( drag );
    }

    static class DragListener extends MouseInputAdapter
    {
        Point location;
        MouseEvent pressed;

        public void mousePressed(MouseEvent me)
        {
            pressed = me;
        }

        public void mouseDragged(MouseEvent me)
        {
            Component component = me.getComponent();
            location = component.getLocation(location);
            int x = location.x - pressed.getX() + me.getX();
            int y = location.y - pressed.getY() + me.getY();
            component.setLocation(x, y);
            ((JComonent)component.getParent()).revalidate();
         }
    }
}