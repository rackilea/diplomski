import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelTest extends JFrame
{
    private JPanel eastPanel;

    public PanelTest()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        Container container = getContentPane();

        eastPanel = new JPanel();
        eastPanel.setBackground(Color.DARK_GRAY);

        JPanel westPanel = new JPanel();
        westPanel.setBackground(Color.YELLOW);

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.BLUE);

        container.add(eastPanel, BorderLayout.LINE_START);
        container.add(centerPanel, BorderLayout.CENTER);
        container.add(westPanel, BorderLayout.LINE_END);
        eastPanel.setVisible(false);

        JButton showButton = new JButton("Click Me to Display EAST JPanel");
        showButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                eastPanel.setVisible(true);
            }
        });

        JButton hideButton = new JButton("Click Me to Hide EAST JPanel");
        hideButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                eastPanel.setVisible(false);
            }
        });

        container.add(hideButton, BorderLayout.PAGE_START);
        container.add(showButton, BorderLayout.PAGE_END);

        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new PanelTest();
            }
        });
    }
}