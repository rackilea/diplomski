import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ThreadCounter
{
    private CustomThread cThread;
    private JTextField tField;
    private JButton button;
    private int counter;

    public ThreadCounter()
    {
        counter = 0;
    }

    private void displayGUI()
    {
        JFrame frame = new JFrame("Thread Counter Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel();
        tField = new JTextField(10);
        tField.setText("0");
        button = new JButton("Start");
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                if (counter == 0)
                {
                    cThread = new CustomThread(tField);
                    cThread.setFlagValue(true);
                    cThread.start();
                    counter = 1;
                    button.setText("Stop");
                }
                else
                {
                    try
                    {
                        cThread.setFlagValue(false);
                        cThread.join();
                    }
                    catch(InterruptedException ie)
                    {
                        ie.printStackTrace();
                    }
                    counter = 0;
                    button.setText("Start");
                }
            }
        });

        contentPane.add(tField);
        contentPane.add(button);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new ThreadCounter().displayGUI();
            }
        });
    }
}

class CustomThread extends Thread
{
    private int changingVariable;
    private JTextField tField;
    private boolean flag = true;

    public CustomThread(JTextField tf)
    {
        changingVariable = 0;
        tField = tf;
    }   

    public void setFlagValue(boolean flag)
    {
        this.flag = flag;
    }

    @Override
    public void run()
    {
        while (flag)
        {
            EventQueue.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    tField.setText(
                        Integer.toString(
                            ++changingVariable));
                }
            });

            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ie)
            {
                ie.printStackTrace();
            }
        }
        System.out.println("I am OUT of WHILE");
    }    
}