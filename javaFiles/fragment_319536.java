import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Draw extends JPanel { // Class names should start with an uppercase letter

    private int xmin, xmax, ymin, ymax;
    private ArrayList<Point> points = new ArrayList<Point>(); // Create a list where all clicked points will be stored

    public Draw() {
        xmin = 150;
        ymin = 150;
        xmax = 650;
        ymax = 650;
        addMouseListener(new MouseAdapter() { // Add MouseListener in the constructor
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = new Point(e.getX(), e.getY());
                if (point.x >= xmin && point.x <= xmax && point.y >= ymin
                        && point.y <= ymax) {
                    points.add(point); // Add the point to the list
                    repaint();
                }
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        int stroke[] = { 1, 2, 3, 4, 5 };

        g2.setStroke(new BasicStroke(stroke[1]));
        int xsize = xmax - xmin;
        int ysize = ymax - ymin;
        g2.drawRect(xmin, ymin, xsize, ysize);
        for (int i = 50; i <= xsize; i += 50) {
            g2.drawLine(xmin + i, ymin, xmin + i, ymax);
            g2.drawLine(xmin, ymin + i, xmax, ymin + i);

        }
        g2.setStroke(new BasicStroke(stroke[0]));
        for (int i = 10; i <= xsize; i += 10) {
            g2.drawLine(xmin + i, ymin, xmin + i, ymax);
            g2.drawLine(xmin, ymin + i, xmax, ymin + i);

        }
        drawPoints(g2);
    }

    private void drawPoints(Graphics2D g2) {
        for (Point point : points) { // Loop through the list of points
            g2.fillOval(point.x - 3, point.y - 3, 7, 7);
        }
    }

    public static void main(String args[]) {
        JFrame jframe = new JFrame("TEST");
        Draw d = new Draw();
        jframe.setSize(800,800);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setContentPane(d);
        jframe.setVisible(true);
    }

}