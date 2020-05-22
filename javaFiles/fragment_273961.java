import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;
import javax.imageio.ImageIO;

public class ButtonImageExample
{
    private ImageIcon image, imageForLabel;
    private JLabel imageLabel;

    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;

    private void displayGUI()
    {
        JFrame frame = new JFrame("Button Image Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(5, 5));
        try
        {
            image = new ImageIcon(ImageIO.read(
                    new URL("http://i.imgur.com/jwyrvXC.gif")));
            imageForLabel = new ImageIcon(ImageIO.read(
                    new URL("http://i.imgur.com/09zgEvG.jpg")));           
        }
        catch(MalformedURLException mue)
        {
            mue.printStackTrace();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }       

        imageLabel = new JLabel(imageForLabel);
        JPanel basePanel = new JPanel();
        // setOpaque(false) is used to make the JPanel translucent/transparent.
        basePanel.setOpaque(false);
        basePanel.setLayout(new BorderLayout(5, 5));
        JPanel topPanel = new JPanel();     
        topPanel.setOpaque(false);
        topPanel.setLayout(new GridLayout(2, 2, 5, 5));
        JLabel userLabel = new JLabel("USERNAME : ", JLabel.CENTER);
        userLabel.setForeground(Color.WHITE);
        userField = new JTextField(10);
        JLabel passLabel = new JLabel("PASSWORD : ", JLabel.CENTER);
        passLabel.setForeground(Color.WHITE);
        passField = new JPasswordField(10);

        topPanel.add(userLabel);
        topPanel.add(userField);
        topPanel.add(passLabel);
        topPanel.add(passField);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setOpaque(false);
        loginButton = new JButton("Click to LOGIN");
        loginButton.setIcon(image);
        loginButton.setHorizontalTextPosition(AbstractButton.CENTER);
        loginButton.setVerticalTextPosition(AbstractButton.BOTTOM);
        bottomPanel.add(loginButton);

        basePanel.add(topPanel, BorderLayout.CENTER);
        basePanel.add(bottomPanel, BorderLayout.PAGE_END);

        imageLabel.setLayout(new GridBagLayout());
        imageLabel.add(basePanel);

        contentPane.add(imageLabel, BorderLayout.CENTER);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new ButtonImageExample().displayGUI();
            }
        });
    }
}