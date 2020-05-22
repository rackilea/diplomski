import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import javax.imageio.ImageIO;

/**
 * @author
 *
 */
public class New2 extends JFrame
{
    private static String SHOW_ACTION = "show";
    private static String HIDE_ACTION = "hide";

    public New2(String filename) 
    {
        setTitle("MyWindow");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);        

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(createControls(), BorderLayout.CENTER);
    }

    private JPanel createControls() 
    {
        JButton showButton = new JButton("Show");        
        showButton.setActionCommand(SHOW_ACTION);

        JButton hideButton = new JButton("Hide");        
        hideButton.setActionCommand(HIDE_ACTION);

        JLabel imageLabel = new JLabel();

        New2Controller n2c = new New2Controller(showButton
                                      , hideButton, imageLabel);
        showButton.addActionListener(n2c);          
        hideButton.addActionListener(n2c);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        panel.add(imageLabel);
        panel.add(showButton);
        panel.add(hideButton);

        return panel;
    }

    /**
     * @param args
     */
    public static void main(String[] args) 
    {
        EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                New2 frame = new New2("/img/image.jpg");  
                frame.setVisible(true);
            }
        });
    }
}

class New2Controller implements ActionListener
{
    private JButton showButton;
    private JButton hideButton;
    private JLabel imageLabel;
    private Image image;
    private ImageIcon imageIcon;
    private static String SHOW_ACTION = "show";
    private static String HIDE_ACTION = "hide";

    public New2Controller(JButton show, JButton hide, JLabel label)
    {
        showButton = show;
        hideButton = hide;
        imageLabel = label;
        try
        {
            image = ImageIO.read(getClass().getResource("/img/caIcon.png"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        imageIcon = new ImageIcon(image);
    }

    public void actionPerformed(ActionEvent event)
    {
        String actionCommand = event.getActionCommand();

        if (SHOW_ACTION.equals(actionCommand)) 
        {
            SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {                       
                    imageLabel.setIcon(imageIcon );
                }
            });
        } 
        else if (HIDE_ACTION.equals(actionCommand)) 
        {
            imageLabel.setIcon(null);
        }
    }
}