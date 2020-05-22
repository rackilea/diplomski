import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;


public class PaintProgram extends JPanel implements MouseListener 
{
    private int xX1, yY1 , xX2, yY2;
    private PaintOperation currentOperation;
    private void setCurrentOperation(PaintOperation po) { currentOperation = po; }

    private class PaintOperation {
        private int choice;
        public PaintOperation(final PaintProgram context, String text, int choice) {
            this.choice = choice;
            final JButton button = new JButton(text);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    context.setCurrentOperation(PaintOperation.this);
                    context.repaint();
                    System.out.println("PaintOperation: "+button.getText());
                }
            });
            context.add(button);
        }
    }

    public static void main(String [] args)
    {
        new PaintProgram();
    }

    PaintProgram()
    {
        JFrame frame = new JFrame("Paint Program");
        frame.setSize(1200, 800);
        frame.getContentPane().add(this);

        new PaintOperation(this, "Empty rectangle", 1);
        new PaintOperation(this, "Empty oval", 2);
        new PaintOperation(this, "Filled rectangle", 3);
        new PaintOperation(this, "Filled oval", 4);
        new PaintOperation(this, "Line", 5);
        setCurrentOperation(new PaintOperation(this, "Clear", 6));

        addMouseListener(this);

        frame.setVisible(true);     
    }

    public void paintComponent(Graphics g)
    { 
        super.paintComponent(g);  
        Graphics2D g2 = (Graphics2D)g;
        if (grid == null) {
            int w = this.getWidth();
            int h = this.getHeight();
            grid = (BufferedImage)(this.createImage(w,h));
            gc = grid.createGraphics();
        }
        g2.drawImage(grid, null, 0, 0);
        check();
    }
    BufferedImage grid;
    Graphics2D gc;


    public void draw()
    {
        Graphics2D g = (Graphics2D)getGraphics();
        int w = xX2 - xX1;
        if (w<0)
            w = w *(-1);

        int h = yY2-yY1;
        if (h<0)
            h=  h*(-1);

        switch(currentOperation.choice)
        {
        case 1:
            check();
            gc.setColor(Color.YELLOW);
            gc.drawRect(xX1, yY1, w, h);
            repaint();
            break;

        case 2:
            check();
            gc.setColor(Color.CYAN);
            gc.drawOval(xX1, yY1, w, h);
            repaint();
            break;

        case 3:
            check();
            gc.setColor(Color.ORANGE);
            gc.drawRect(xX1, yY1, w, h);
            gc.fillRect(xX1, yY1, w, h);
            repaint();
            break;

        case 4:
            check();
            gc.drawOval(xX1, yY1, w, h);
            gc.setColor(Color.PINK);
            gc.fillOval(xX1, yY1, w, h);
            repaint();
            break;  

        case 5:
            check();
            gc.setColor(Color.MAGENTA);
            gc.drawLine(xX1, yY1, xX2, yY2);
            repaint();
            break;

        case 6:
            //Acquire clear screen or gay
            break;   
        }
    }

    public void check()
    {
        if (xX1 > xX2)
        {
            int z = 0;
            z = xX1;
            xX1 = xX2;
            xX2 =z;
        }
        if (yY1 > yY2)
        {
            int z = 0;
            z = yY1;
            yY1 = yY2;
            yY2 = z;
        }
    }

    public void mouseExited(MouseEvent evt){}
    public void mouseEntered(MouseEvent evt){}
    public void mouseClicked(MouseEvent evt){}
    public void mousePressed(MouseEvent evt)
    {
        xX1 = evt.getX();
        yY1= evt.getY();
    }
    public void mouseReleased(MouseEvent evt)
    {
        xX2 =evt.getX();
        yY2=evt.getY();
        draw();
    }
}