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
    private ImageIcon pictures1, pictures2, pictures3, pictures4;
    private ActionListener action = new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {                       
            i++;
            System.out.println(i);

            if(i == 1)
            {
                pictures1 = new ImageIcon("image/caIcon.png");
                images.setIcon(icons[i - 1]);
                System.out.println("picture 1 should be displayed here");
            }
            if(i == 2)
            {
                pictures2 = new ImageIcon("image/Keyboard.png");
                images.setIcon(icons[i - 1]);   
                System.out.println("picture 2 should be displayed here");
            }
            if(i == 3)
            {
                pictures3 = new ImageIcon("image/ukIcon.png");
                images.setIcon(icons[i - 1]);
                System.out.println("picture 3 should be displayed here");  
            }
            if(i == 4)
            {
                pictures4 = new ImageIcon("image/Mouse.png");
                images.setIcon(icons[0]);   
                System.out.println("picture 4 should be displayed here");  
            }
            if(i == 5)
            {
                timer.stop();
                System.exit(0);
            }
            revalidate();
            repaint();
        }
    };

    public SlideShow()
    {
        JFrame frame = new JFrame("SLIDE SHOW");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

        frame.getContentPane().add(this);

        add(images);

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
                new SlideShow();
            }
        });
    }
}