import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game1 implements KeyListener
{

    int BACK_WIDTH = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    int BACK_HEIGHT = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

    JFrame back_frame = new JFrame();
    JPanel window = new JPanel();
    JLabel title = new JLabel("Title");

    Terminal1 login = new Terminal1();

    public static void main(String[] args)
    {
        new Game1();
    }

    public Game1()
    {
        try
        {

            back_frame.setSize(BACK_WIDTH, BACK_HEIGHT);
            back_frame.setLocation(0, 0);
            back_frame.getContentPane().setBackground(Color.BLACK);
            back_frame.setUndecorated(true);
            back_frame.setVisible(true);
            back_frame.add(window);
            window.setBackground(Color.BLACK);
            window.setLayout(null);

            window.add(title);
            title.setBounds((BACK_WIDTH / 2) - (550 / 2), (BACK_HEIGHT / 2) - (50 / 2), 550, 50);
            title.setForeground(Color.WHITE);

            back_frame.addKeyListener(this);
            login.addKeyListener(this);
            login.setLocationRelativeTo(null);
            login.setVariables(Types.LOGINTERMINAL);

            waitForStart();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    int index;

    public void waitForStart()
    {
        Timer timer = new Timer(2000, new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (index < 1 && index >= 0)
                {
                    index++;
                }
                else
                {
                    ((Timer) e.getSource()).stop();

                    login.setVisible(true);
                    login.slowPrint("Please login to continue...\n" + "Type 'help' for more information.\n");
                }
            }
        });
        timer.start();
    }

    public void keyPressed(KeyEvent e)
    {
        int i = e.getKeyCode();

        if (i == KeyEvent.VK_ESCAPE)
        {
            System.exit(0);
        }
    }

    public void keyReleased(KeyEvent e)
    {
    }

    public void keyTyped(KeyEvent e)
    {
    }

}