import java.awt.Dimension;
import javax.swing.*;

public class LeftSide
{
    public LeftSide()
    {
        JFrame frame = new JFrame("Button");
        JPanel panel = new JPanel();
        JButton button = new JButton("Submit");
        button.setPreferredSize(new Dimension(200, 30));
        button.setIcon(new ImageIcon(this.getClass().getResource("submit.gif")));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(button);
        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        new LeftSide();
    }
}