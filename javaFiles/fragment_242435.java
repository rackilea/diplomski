import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TwoFrames
{
    private SecondFrame secondFrame;

    private void createAndDisplayGUI()
    {
        JFrame frame = new JFrame("JFRAME 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

        secondFrame = new SecondFrame();
        secondFrame.createAndDisplayGUI();
        secondFrame.tfield.setText("I will be same everytime.");

        JPanel contentPane = new JPanel();  
        JButton showButton = new JButton("SHOW JFRAME 2");
        showButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                if (!(secondFrame.isShowing()))
                    secondFrame.setVisible(true);
            }
        });

        frame.add(contentPane, BorderLayout.CENTER);
        frame.add(showButton, BorderLayout.PAGE_END);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new TwoFrames().createAndDisplayGUI();
            }
        });
    }
}

class SecondFrame extends JFrame
{
    private WindowAdapter windowAdapter;
    public JTextField tfield;

    public void createAndDisplayGUI()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        JPanel contentPane = new JPanel();

         tfield = new JTextField(10);

        windowAdapter = new WindowAdapter()
        {
            public void windowClosing(WindowEvent we)
            {
                setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            }
        };

        addWindowListener(windowAdapter);
        contentPane.add(tfield);

        getContentPane().add(contentPane);
        setSize(300, 300);      
    }
}