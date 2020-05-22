import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class TwoPanel {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                showMainWindow();
            }
        });
    }

    public static void showMainWindow() {
        JFrame frame = new JFrame ("Key test");
        MyDrawPanel1 dp1 = new MyDrawPanel1();
        //MyDrawPanel2 dp2 = new MyDrawPanel2();
        //MyDrawPanel3 dp3 = new MyDrawPanel3();
        //MyDrawPanel4 dp4 = new MyDrawPanel4();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p = new JPanel ();
        p.setLayout(new BorderLayout());
        p.add (dp1);
        //p.add (dp2);
        //p.add(dp3);
        //p.add(dp4);
        frame.getContentPane().add(p);
        frame.setLocationRelativeTo(null); // center frame
        frame.setMinimumSize(new Dimension(300,400)); // make the frame at least 300x400
        frame.pack();
        frame.setVisible(true);
    }
}