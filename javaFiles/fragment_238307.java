import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class MainFrame2 extends JFrame {

    private JPanel card1;
    private BufferedImage image;

    public MainFrame2() {

        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        try {
            // if there is a problem with URL - no point trying to load
            URL url = new URL("https://i.stack.imgur.com/7bI1Y.jpg");
            image = ImageIO.read(url);
        } catch (Exception e) {
            System.out.println("Problem loading image");
            e.printStackTrace();
        }

        /* The frame will actually be larger than the panel. 
        Better to scale the image to the SIZE OF THE PANEL ...
        Image scaledImage = image.getScaledInstance(this.getWidth(),
                this.getHeight(), Image.SCALE_SMOOTH); */

        card1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // .. this is how.
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };

        setContentPane(card1);

        setVisible(true); // this should be last! 
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame2();
            }
        });
    }
}