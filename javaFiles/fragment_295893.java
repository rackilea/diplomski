import java.awt.*;
import javax.swing.*;

public class Check {

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                Check c = new Check();
                c.init();
            }
        });
    }

    public void init() {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(3);

        JPanel panel = new JPanel();

        frame.setSize(new Dimension(800, 600));
        frame.setTitle("Test");
        frame.getContentPane().add(panel);
        frame.setVisible(true);

        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                Graphics2D g = (Graphics2D)panel.getGraphics();
                g.setColor(Color.BLUE);
                g.fillOval(50, 50, 50, 50);
            }
        });
    }
}