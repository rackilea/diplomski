import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class RectangleC extends JComponent implements MouseListener{
    private int width, height;
    int x,y;
    private Color color;

    public RectangleC(int w, int h, Color c){
        width = w;
        height = h;

        //Given x and y some default position. This can be changed as required
        x = 20;
        y = 20;

        color = c;
        this.addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        int currentX = e.getX();
        int currentY = e.getY();
        if(currentX > this.getRectX() && currentX < this.getRectX() + width && currentY > this.getRectY() && currentY < this.getRectY() + height ){        
            if(color != Color.WHITE)
                color = Color.WHITE;
            else
                color = Color.black;
        }
        repaint();
    }

    // Function to return rectangle coordinate
    private int getRectX() {
        return this.getX()+x;
    }


    private int getRectY() {
        return this.getY()+y;
    }
public void mouseClicked(MouseEvent e){};
    public void mouseReleased(MouseEvent e){};
    public void mouseEntered(MouseEvent e){};
    public void mouseExited(MouseEvent e){};

    public static void main(String args[]){
        JFrame frame = new JFrame("Rectangle Component");
        RectangleC rectangle2 = new RectangleC(300, 500, Color.BLACK);
        frame.add(rectangle2);
        frame.setSize(600,600);;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}