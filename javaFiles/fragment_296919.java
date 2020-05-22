import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SlideShow extends JPanel
{
    private int i = 0;
    private Timer timer;
    private JLabel images = new JLabel();
    private Icon[] icons = {UIManager.getIcon("OptionPane.informationIcon"),
                            UIManager.getIcon("OptionPane.errorIcon"),
                            UIManager.getIcon("OptionPane.warningIcon")};
    private ActionListener action = new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {                       
            i++;
            System.out.println(i);          

            if(i == 4)
            {
                timer.stop();
                System.exit(0);
            }
            remove(images);
            JLabel temp = new JLabel(icons[i - 1]);
            images = temp;
            add(images);
            revalidate();
            repaint();
        }
    };

    private void createAndDisplayGUI()
    {
        JFrame frame = new JFrame("SLIDE SHOW");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);    

        this.setLayout(new FlowLayout(FlowLayout.LEFT));    

        add(images);

        frame.getContentPane().add(this, BorderLayout.CENTER);

        frame.setSize(300, 300);
        frame.setVisible(true); 
        timer = new Timer(2000, action);    
        timer.start();  
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new SlideShow().createAndDisplayGUI();
            }
        });
    }
}