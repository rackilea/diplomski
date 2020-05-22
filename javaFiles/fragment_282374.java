import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class CircleDraw extends Frame {

    public void paint(Graphics g) {
        Graphics2D ga = (Graphics2D) g;

        ga.setPaint(Color.YELLOW);
        Arc2D arc2D4 = new Arc2D.Double(100.0f, 100.0f, 100.0f, 100.0f, 90, 270, Arc2D.PIE);
        ga.fill(arc2D4);
        ga.draw(arc2D4);

        ga.setPaint(Color.GREEN);
        Arc2D arc2D1 = new Arc2D.Double(100.0f, 100.0f, 100.0f, 100.0f, 90, 90d, Arc2D.PIE);
        ga.fill(arc2D1);
        ga.draw(arc2D1);

        ga.setPaint(Color.RED);
        Arc2D arc2D2 = new Arc2D.Double(100.0f, 100.0f, 100.0f, 100.0f, 360, 90d, Arc2D.PIE);
        ga.fill(arc2D2);
        ga.draw(arc2D2);

        ga.setPaint(Color.BLUE);
        Arc2D arc2D3 = new Arc2D.Double(100.0f, 100.0f, 100.0f, 100.0f, 180, 90d, Arc2D.PIE);
        ga.fill(arc2D3);
        ga.draw(arc2D3);

    }

    public static void main(String args[]) {
        Frame frame = new CircleDraw();
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        frame.setSize(300, 250);
        frame.setVisible(true);
    }
}