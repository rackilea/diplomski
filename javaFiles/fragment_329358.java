import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class MenuTest {

    public static void main(String[] argv) throws Exception {
        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();

        String imageURL = "http://blogs.discovermagazine.com/" +
            "drone360/wp-content/themes/discoverblog/images/" +
            "gear_icon.png";

        // Create a menu
        JMenu menu = new JMenu("Menu");
        BufferedImage image = ImageIO.read(new URL(imageURL));
        menu.setHorizontalTextPosition(SwingConstants.CENTER);
        menu.setVerticalTextPosition(SwingConstants.BOTTOM);
        menu.setIcon(new ImageIcon(image));
        menuBar.add(menu);

        // Create a menu item
        JMenuItem item = new JMenuItem("Test Item");

        menu.add(item);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setJMenuBar(menuBar);
        frame.setSize(500, 550);
        frame.setVisible(true);
    }
}