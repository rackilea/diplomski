import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class CustomFrame1 implements MouseListener
{

    JFrame frame = new JFrame();
    public static Paint window = null;

    public void addKeyListener(KeyListener listener)
    {
        frame.addKeyListener(listener);
    }

    private Point initialClick;
    private boolean inBounds = false;

    public int getWidth()
    {
        return frame.getWidth();
    }

    public int getHeight()
    {
        return frame.getHeight();
    }

    public void add(JComponent component)
    {
        window.add(component);
    }

    public void setLocation(int x, int y)
    {
        frame.setLocation(x, y);
    }

    public void setLocationRelativeTo(Component c)
    {
        frame.setLocationRelativeTo(c);
    }

    private void setFrameType(Types type)
    {
        switch (type)
        {
        case TERMINAL:
            frame.setSize(600, 400);
            break;
        case LOGINTERMINAL:
            frame.setSize(600, 400);
            break;
        case NOTIFICATION:
            frame.setSize(300, 150);
            break;
        default:
            frame.setSize(600, 400);
            break;
        }
    }

    int index = 0;

    public void slowPrint(final String text, final JTextArea field)
    {
        Timer timer = new Timer(40, new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (index < text.length() && index >= 0)
                {
                    String newChar = Character.toString(text.charAt(index));
                    field.append(newChar);
                    index++;
                }
                else
                {
                    field.append("\n");

                    index = 0;
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.start();
    }

    public void slowPrintAndClear(final String text, final JTextArea field, final boolean andQuit)
    {
        Timer timer = new Timer(40, new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (index < text.length() && index >= 0)
                {
                    String newChar = Character.toString(text.charAt(index));
                    field.append(newChar);
                    index++;
                }
                else
                {
                    field.append("\n");

                    if (andQuit == false)
                    {
                        field.setText(null);
                    }
                    else
                    {
                        System.exit(0);
                    }

                    index = 0;
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.start();
    }

    public CustomFrame1(Types type)
    {

        window = new Paint(frame);
        frame.setAlwaysOnTop(true);
        frame.addMouseListener(this);
        frame.setResizable(false);
        frame.setUndecorated(true);
        setFrameType(type);
        frame.add(window);
        window.setLayout(null);

        frame.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                initialClick = e.getPoint();
                frame.getComponentAt(initialClick);
            }
        });

        frame.addMouseMotionListener(new MouseMotionAdapter()
        {
            public void mouseDragged(MouseEvent e)
            {
                if (e.getX() >= 0 && e.getX() <= frame.getWidth() && e.getY() >= 0 && e.getY() <= 20)
                {
                    inBounds = true;
                }
                if (inBounds == true)
                {
                    int thisX = frame.getLocation().x;
                    int thisY = frame.getLocation().y;
                    int xMoved = (thisX + e.getX()) - (thisX + initialClick.x);
                    int yMoved = (thisY + e.getY()) - (thisY + initialClick.y);
                    int x = thisX + xMoved;
                    int y = thisY + yMoved;
                    frame.setLocation(x, y);
                }
            }
        });
    }

    public void dispose()
    {
        frame.dispose();
    }

    public JFrame setVisible(boolean bool)
    {
        frame.setVisible(bool);
        return null;
    }

    public void mouseClicked(MouseEvent e)
    {
    }

    public void mouseEntered(MouseEvent e)
    {
    }

    public void mouseExited(MouseEvent e)
    {
    }

    public void mousePressed(MouseEvent e)
    {
        int x = e.getX();
        int y = e.getY();

        if (x >= frame.getWidth() - 20 && x <= frame.getWidth() - 6 && y >= 3 && y <= 14)
        {
            frame.dispose();
        }

    }

    public void mouseReleased(MouseEvent e)
    {
        inBounds = false;
    }

}

class Paint extends JPanel
{
    private static final long serialVersionUID = 1L;

    private JFrame frame;

    public Paint(JFrame frame)
    {
        this.frame = frame;
    }

    private void doDrawing(Graphics g)
    {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, frame.getWidth(), frame.getHeight());

        Color LIGHT_BLUE = new Color(36, 171, 255);

        // g2d.setColor(Color.BLUE);
        GradientPaint topFill = new GradientPaint(0, 0, LIGHT_BLUE, frame.getWidth(), 20, Color.BLUE);
        g2d.setPaint(topFill);

        g2d.fillRect(0, 0, frame.getWidth(), 20);

        g2d.setColor(Color.WHITE);
        g2d.drawRect(0, 0, frame.getWidth() - 1, frame.getHeight() - 1);
        g2d.drawLine(0, 20, frame.getWidth(), 20);

        g2d.fillRect(frame.getWidth() - 20, 3, 14, 14);

    }

    public void paintComponent(Graphics g)
    {

        super.paintComponent(g);
        doDrawing(g);
    }
}