import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class MyCanvas extends Canvas {

    int w, h; // width and height
    int samples;
    ArrayList<Point> eqValues = new ArrayList<>();              //Point constructor receives 2 int arguments: x and y; however, his methods getX() and getY() return double values

    // constructor
    MyCanvas(int wi, int he) {
        w = wi;
        h = he;
        setSize(w, h);                                          // determine size of canvas
        samples = wi - 20;
    }

    public void paint(Graphics g) {
        int x1, y0, y1;                                         // previous and new function value

        g.setColor(Color.yellow);
        g.fillRect(0, 0, w, h);                                 // clear canvas

        g.setColor(Color.black);
        if (eqValues.size() > 0) {                              // draw new graph
            y0 = (int) Math.round(eqValues.get(0).getY());      // first line must start at the first point, not at 0,h
            for (Point p : eqValues) {                          // iterates over the ArrayList
                x1 = (int) Math.round(p.getX());
                y1 = (int) Math.round(p.getY());
                g.drawLine(10 + x1 - 1, h - y0, 10 + x1, h - y1);
                y0 = y1;
            }
        }

        System.out.println("Repainted");

    }

    public void drawSine(double amp, double xCoef, double phase) {
        for (int j = 0; j <= samples; j++) {
            eqValues.add(new Point(j, (int) Math
                    .round(amp * Math.sin(xCoef * Math.PI * j / samples + Math.PI * phase / 180) + 0.5 + h / 2)));
        }
        repaint();
        System.out.println("Got sine vals");
    }

    public void drawFOeq(double sc, double fc) {
        for (int j = 0; j <= samples; j++) {
            eqValues.add(new Point(j, (int) Math.round(sc * j + fc)));
        }
        repaint();
        System.out.println("Got FO eq vals");
    }
}