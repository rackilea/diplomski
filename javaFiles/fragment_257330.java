import javax.swing.*;
import java.awt.*;

public class GUITimer extends JFrame
{
    private static final long serialVersionUID = 1L;
    private int seconds = 0;
    private Thread timerThread;
    private JLabel timeDisplay;

    public GUITimer()
    {
        initGUI();
        pack();
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initGUI()
    {
        JLabel title = new JLabel("Timer");
        Font titleFont = new Font(Font.SERIF, Font.BOLD, 32);
        title.setFont(titleFont);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBackground(Color.BLACK);
        title.setForeground(Color.WHITE);
        title.setOpaque(true);
        add(title, BorderLayout.NORTH);
        timeDisplay = new JLabel(Integer.toString(seconds));//this label shows seconds
        add(timeDisplay, BorderLayout.CENTER);
    }

    public void start()
    {
        seconds = 0;
        timerThread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while(true)
                {
                    timeDisplay.setText(Integer.toString(seconds++));
                    try
                    {
                        Thread.sleep(1000L);
                    }
                    catch(InterruptedException e) {}
                }
            }
        });
        timerThread.start();
    }

    public void stop()
    {
        timerThread.interrupt();
    }

    public static void main(String[] args)
    {
        try
        {
            GUITimer timer = new GUITimer();
            timer.start();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}