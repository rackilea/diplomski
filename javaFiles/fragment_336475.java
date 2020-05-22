import java.awt.*;
import javax.swing.*;

public class PanelPaintingExample
{
    private ColouredRectangle cRect, cRect1, cRect2;    
    private Rectangle rect;

    public PanelPaintingExample()
    {       
        rect = new Rectangle(0, 0, 200, 30);
    }

    private void displayGUI()
    {   
        JFrame frame = new JFrame("Panel Painting Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        cRect = new ColouredRectangle(Color.RED, "LABEL 1"
                                               , Color.WHITE
                                               , rect);
        cRect1 = new ColouredRectangle(Color.BLUE, "LABEL 2"
                                               , Color.WHITE
                                               , rect);
        cRect2 = new ColouredRectangle(Color.MAGENTA, "LABEL 3"
                                               , Color.WHITE
                                               , rect);                                     

        frame.add(cRect);
        frame.add(cRect1);
        frame.add(cRect2);
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
                new PanelPaintingExample().displayGUI();
            }
        });
    }
}

class ColouredRectangle extends JPanel
{
    private Color backColour;
    private Color foreColour;
    private String text;
    private Rectangle rect;

    private JLabel label;

    public ColouredRectangle(Color b, String text
                                     , Color f, Rectangle rect)
    {
        this.backColour = b;
        this.foreColour = f;
        this.text = text;
        this.rect = rect;

        label = new JLabel(this.text, JLabel.CENTER);
        label.setOpaque(true);
        label.setBackground(backColour);
        label.setForeground(foreColour);

        add(label);
    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(200, 30));
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(backColour);
        g.fillRect((int)rect.getX(), (int)rect.getY()
                              , (int)rect.getWidth()
                              , (int)rect.getHeight());
    }
}