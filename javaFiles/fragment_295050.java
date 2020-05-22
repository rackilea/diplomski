import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public class MyPanel extends JPanel implements MouseListener {

    public MyPanel() {
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        setBackground(Color.BLACK);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {   
    }

    @Override
    public void mouseEntered(MouseEvent e) {    
    }

    @Override
    public void mouseExited(MouseEvent e) { 
    }
}