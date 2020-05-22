import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;
import javax.imageio.ImageIO;

public class ButtonImageExample
{
    private JButton imageButton;
    private ImageIcon image;

    private void displayGUI()
    {
        JFrame frame = new JFrame("Button Image Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        try
        {
            image = new ImageIcon(ImageIO.read(
                    new URL("http://i.imgur.com/6mbHZRU.png")));
        }
        catch(MalformedURLException mue)
        {
            mue.printStackTrace();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }       

        imageButton = new JButton("Button Text");
        imageButton.setIcon(image);
        imageButton.setHorizontalTextPosition(AbstractButton.CENTER);
        imageButton.setVerticalTextPosition(AbstractButton.BOTTOM);

        contentPane.add(imageButton);

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