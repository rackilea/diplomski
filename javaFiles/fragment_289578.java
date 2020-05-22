import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GridExample
{
    private static final int SIZE = 36;
    private JButton[] buttons;
    private int presentPos;
    private int desiredPos;
    private Timer timer;
    private Icon infoIcon = 
                UIManager.getIcon("OptionPane.informationIcon");

    private ActionListener timerAction = new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
            buttons[presentPos].setIcon(null);
            if (desiredPos < presentPos)
            {
                presentPos--;
                buttons[presentPos].setIcon(infoIcon);
            }
            else if (desiredPos > presentPos)
            {
                presentPos++;
                buttons[presentPos].setIcon(infoIcon);
            }
            else if (desiredPos == presentPos)
            {
                timer.stop();
                buttons[presentPos].setIcon(infoIcon);
            }
        }
    };

    public GridExample()
    {
        buttons = new JButton[SIZE];
        presentPos = 0;
        desiredPos = 0;
    }

    private void createAndDisplayGUI()
    {
        JFrame frame = new JFrame("Grid Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(6, 6, 5, 5));
        for (int i = 0; i < SIZE; i++)
        {
            final int counter = i;
            buttons[i] = new JButton();
            buttons[i].setActionCommand("" + i);
            buttons[i].addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
                    desiredPos = Integer.parseInt(
                                    (String) buttons[counter].getActionCommand());
                    timer.start();              
                }
            });
            contentPane.add(buttons[i]);
        }
        buttons[presentPos].setIcon(infoIcon);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        timer = new Timer(1000, timerAction);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new GridExample().createAndDisplayGUI();
            }
        });
    }
}