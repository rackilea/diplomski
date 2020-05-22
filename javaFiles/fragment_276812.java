import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class LineDrawSwing extends JLabel implements Icon {
    Line2D line1, line2;

    public LineDrawSwing() { this.setIcon(this); }

    Stroke drawingStroke1 = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0,
            new float[] { 9 }, 0);

    public static void main(String args[]) {
        JFrame frame = new JFrame();
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        frame.add(new LineDrawSwing());
        frame.validate();
        frame.setSize(300, 250);
        frame.setVisible(true);
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Dimension size = getSize();
        line1 = new Line2D.Double(size.width/2, size.height-10, 10, 10);
        line2 = new Line2D.Double(size.width/2, size.height-10, size.width-10, 10);
        Graphics2D graph = (Graphics2D) g;
        graph.setPaint(Color.red);
        graph.draw(line2);
        graph.setStroke(drawingStroke1);
        graph.setPaint(Color.green);
        graph.draw(line1);
    }

    @Override
    public int getIconHeight() {
        return getSize().height;
    }

    @Override
    public int getIconWidth() {
        return getSize().width;
    }
}