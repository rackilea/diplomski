import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.*;

class DrawPanel extends JPanel {

    private static final long serialVersionUID = 776058311964590886L;

    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        // points
        Point2D.Double pt1 = new Point2D.Double(100, 10);
        Point2D.Double pt2 = new Point2D.Double(125, 75);
        Point2D.Double pt3 = new Point2D.Double(200, 85);
        Point2D.Double pt4 = new Point2D.Double(150, 125);
        Point2D.Double pt5 = new Point2D.Double(160, 190);
        Point2D.Double pt6 = new Point2D.Double(100, 150);
        Point2D.Double pt7 = new Point2D.Double(40, 190);
        Point2D.Double pt8 = new Point2D.Double(50, 125);
        Point2D.Double pt9 = new Point2D.Double(0, 85);

        // lines
        Line2D.Double ln1 = new Line2D.Double(pt1, pt2);
        Line2D.Double ln2 = new Line2D.Double(pt2, pt3);
        Line2D.Double ln3 = new Line2D.Double(pt3, pt4);
        Line2D.Double ln4 = new Line2D.Double(pt4, pt5);
        Line2D.Double ln5 = new Line2D.Double(pt5, pt6);
        Line2D.Double ln6 = new Line2D.Double(pt6, pt7);
        Line2D.Double ln7 = new Line2D.Double(pt7, pt8);
        Line2D.Double ln8 = new Line2D.Double(pt8, pt9);

        // color of lines
        g2.setColor(Color.BLUE);

        // draw the lines
        g2.draw(ln1);
        g2.draw(ln2);
        g2.draw(ln3);
        g2.draw(ln4);
        g2.draw(ln5);
        g2.draw(ln6);
        g2.draw(ln7);
        g2.draw(ln8);
    }
}

public class StarClass {

    static JFrame frame;

    public static void main(String[] args) {

        DrawPanel panel = new DrawPanel();

        JFrame frame = new JFrame();
        frame.getContentPane().add(panel);

        frame.setSize(400, 400);
        frame.setTitle("My Star");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}