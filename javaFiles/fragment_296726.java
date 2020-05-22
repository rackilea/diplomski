import javax.swing.*;
import java.awt.*;

public class MainFrame
{
    JFrame mainFrame = new JFrame("Main Frame");
    JPanel mainPanel = new JPanel();
    JLabel label1 = new JLabel("Vertical Buttons");
    JButton button1 = new JButton("Button 1");
    JButton button2 = new JButton("Button 2");

    public MainFrame()
    {
        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(label1);
        mainPanel.add(button1);
        mainPanel.add(button2);
        mainFrame.add(mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}