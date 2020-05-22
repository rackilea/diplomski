import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawingExample
{
    private int x;
    private int y;
    private String text;
    private DrawingBase canvas;

    private void displayGUI()
    {
        JFrame frame = new JFrame("Drawing Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        canvas = new DrawingBase();
        canvas.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent me)
            {
                text = "X : " + me.getX() + " Y : " + me.getY();
                x = me.getX();
                y = me.getY();
                canvas.setValues(text, x, y);
            }
        }); 

        frame.setContentPane(canvas);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new DrawingExample().displayGUI();
            }
        });
    }
}

class DrawingBase extends JPanel
{
    private String clickedAt = "";
    private int x = 0;
    private int y = 0;

    public void setValues(String text, int x, int y)
    {
        clickedAt = text;
        this.x = x;
        this.y = y;
        repaint();
    }

    public Dimension getPreferredSize()
    {
        return (new Dimension(500, 400));
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawString(clickedAt, x, y);
    }
}