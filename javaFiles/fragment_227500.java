package users.metropolia;

import java.net.URL;
import javax.swing.ImageIcon;

public class IconManager {
    /** Returns an ImageIcon, or null if the path was invalid. */
    public static ImageIcon loadImageIcon(String path) {
        URL imgURL = IconManager.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
                return null;
        }
    }

    public static void main(String[] args) {
        // Using absolute (to jar) paths
        ImageIcon icon3 = loadImageIcon("/pics/spider.jpg");
        ImageIcon icon4 = loadImageIcon("/imagess/ant.jpg");
    }
}