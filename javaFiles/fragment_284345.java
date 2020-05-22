import java.awt.*;
import java.applet.Applet;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

public class Shapes extends JApplet {
    public static void main(String[] args) {
        JApplet app = new Shapes();
        JFrame f = new JFrame("Example");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.init();
        app.start();
        f.add("Center", app);
        f.pack();
        f.setVisible(true);
    }

    Shapes() {
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine(20, 20, 100, 100);
    }
}