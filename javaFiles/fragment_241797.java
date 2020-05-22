import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class tuna extends JFrame {
    int x, y, w, h;

    MyPanel jpanel = new MyPanel();

    public tuna(){
        super("Painting Program");
        setLayout(new BorderLayout());
        jpanel.setBackground(Color.WHITE);
        add(jpanel);

        hand handler = new hand();
        jpanel.addMouseListener(handler);
        jpanel.addMouseMotionListener(handler);
    }

    private class hand implements MouseListener , MouseMotionListener { //THE ERRORS START TO APPEAR HERE
        public void mouseClicked(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
            x=e.getX();
            y=e.getY();
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mouseDragged(MouseEvent e) {
            w = e.getX() - x;
            h = e.getY() - y;
            jpanel.repaint();
        }

        public void mouseMoved(MouseEvent e) {
        }
    }

    class MyPanel extends JPanel {
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.fillRect(x, y, w, h);
        }
    }
}