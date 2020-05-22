import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class ListenToMice extends JFrame implements MouseListener 
{
    private JLabel[] difference = new JLabel[11];
    public ListenToMice( ) 
    {
        difference[1].addMouseListener(new MouseAdapter()
            {
                public void mousePressed(MouseEvent e) {
                    //this code will now run first (see how it is "mousePressed" above this text
                }

            });
    }

    public void mouseClicked(MouseEvent e) {

    }
    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {
//put code you want second here
    }
}