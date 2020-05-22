import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

public class CatchMeV2 {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(400, 400);
        frame.setTitle("CatchMe.V2");
        RedSquare r = new RedSquare();
        frame.add(r);
    }
}

class RedSquare extends JPanel implements MouseListener {

    int x = 20;
    int y = 20;
    int velX = 4;
    int velY = 4;

    public RedSquare() {
        addMouseListener(this);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        g.fillRect(x, y, 50, 50);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("hi");
        x += velX;
        y += velY;
        if (x < 0) {
            velX = 0;
            x = 0;
        }
        if (x > 400 - 50) {
            velX = 0;
            x = 400 - 50;
        }
        if (y < 0) {
            velY = 0;
            y = 0;
        }
        if (y > 400 - 40) {
            velY = 0;
            y = 400 - 40;
        }
        this.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}


}