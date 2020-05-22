$cat >test.java <<. 
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class test extends JFrame
{

    private JFrame frame;

    public void init()
    {
        trayicon.addMouseListener(new click());
    }

        private class click extends MouseAdapter
        {
            public void mouseEntered(MouseEvent e)
            {
                {
                frame.setVisible(true);
            }
        }
    }
}
.
$javac test.java 
test.java:15: cannot find symbol
symbol  : class MouseAdapter
location: class test
        private class click extends MouseAdapter
                                    ^
test.java:17: cannot find symbol
symbol  : class MouseEvent
location: class test.click
            public void mouseEntered(MouseEvent e)
                                     ^
test.java:12: cannot find symbol
symbol  : variable trayicon
location: class test
        trayicon.addMouseListener(new click());
        ^
3 errors