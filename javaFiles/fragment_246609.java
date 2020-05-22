import java.awt.*;
import javax.swing.*;

public class TestingClass  extends JFrame {

    public static void main(String[] args) {

        JFrame fw = new JFrame();
        fw.setSize(400, 200); // for screenshot
        fw.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p5 = new JPanel(new GridBagLayout());
        p5.setVisible(true);

        fw.add(p5);

        JMenu menu = new JMenu("Menu");
        //menu.setVisible(true);
        menu.add("home");
        menu.add("about");
        menu.add("explore");

        JMenuBar menubar = new JMenuBar();
        fw.setJMenuBar(menubar);    // THE UPDATED LINE OF CODE.
        //menubar.setVisible(true);
        menubar.add(menu);
        //p5.add(menu); // WTF?

        fw.setVisible(true); //should be done after all components are added
    }
}