$ed test.java 
633
26d
21d
wq
605
$javac test.java 
$
$cat test.java 
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class test extends JFrame
{

    private JFrame frame;

    public void init()
    {
        JLabel trayicon = new JLabel();// or something that makes sense
        trayicon.addMouseListener(new click());
    }

        private class click extends MouseAdapter
        {
            public void mouseEntered(MouseEvent e)
            {
                frame.setVisible(true);
            }
        }
    }