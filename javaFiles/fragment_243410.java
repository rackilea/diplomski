package test;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel implements MouseListener,
    MouseMotionListener {

Rectangle currentRectangle = null;
boolean drawingRectangle = false;

/**
 * some java stuff to get rid of warnings
 */
private static final long serialVersionUID = 1L;

/**
 * image to be tagged
 */
BufferedImage image = null;

/**
 * list of current polygon's vertices
 */
ArrayList<Point> currentPolygon = null;

/**
 * list of polygons
 */
ArrayList<ArrayList<Point>> polygonsList = null;

ArrayList<Rectangle> rectangleList = null;

/**
 * extended constructor - loads image to be labelled
 * 
 * @param imageName
 *            - path to image
 * @throws Exception
 *             if error loading the image
 */
public ImagePanel(String imageName) throws Exception {

    currentPolygon = new ArrayList<Point>();
    polygonsList = new ArrayList<ArrayList<Point>>();
    rectangleList = new ArrayList<Rectangle>();

    image = ImageIO.read(new File(imageName));
    Dimension panelSize = new Dimension(image.getWidth(), image.getHeight());
    this.setSize(panelSize);
    this.setMinimumSize(panelSize);
    this.setPreferredSize(panelSize);
    this.setMaximumSize(panelSize);

    setBounds(0, 0, image.getWidth(), image.getHeight());
    addMouseListener(this);
    addMouseMotionListener(this);
    this.setVisible(true);

}

@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    System.out.println("Paint Component");
    Graphics2D g2d = (Graphics2D) g;

    // Paint image on screen
    g2d.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);

    // display all the completed polygons
    for (ArrayList<Point> polygon : polygonsList) {
        drawPolygon(polygon,g);
        finishPolygon(polygon);
        System.out.println("Polly");
    }

    // Display all completed squares
    for (Rectangle r : rectangleList) {
        drawRectangle(r,g);
        System.out.println("Square");
    }

    // display current polygon
    if (currentPolygon != null) {
        drawPolygon(currentPolygon, g);
    }

    // display current square
    if (currentRectangle != null) {
        drawRectangle(currentRectangle, g);
    }
}

/**
 * displays a polygon without last stroke
 * 
 * @param polygon
 *            to be displayed
 */
public void drawPolygon(ArrayList<Point> polygon,  Graphics gr) {
    Graphics2D g = null;
    if (gr instanceof Graphics2D) {
        g = (Graphics2D) gr;
    }
    else{ return; }
    // set to red so I can see when it's being redrawn
    g.setColor(Color.RED);
    g.setStroke(new BasicStroke(3));
    for (int i = 0; i < polygon.size(); i++) {
        Point currentVertex = polygon.get(i);
        if (i != 0) {
            Point prevVertex = polygon.get(i - 1);
            g.drawLine(prevVertex.getX(), prevVertex.getY(),
                    currentVertex.getX(), currentVertex.getY());
        }
        g.fillOval(currentVertex.getX() - 5, currentVertex.getY() - 5, 10,
                10);
    }
}

public void drawRectangle(Rectangle r, Graphics gr) {
    Graphics2D g = null;
    if (gr instanceof Graphics2D) {
        g = (Graphics2D) gr;
    }
    else{ return; }
    g.setStroke(new BasicStroke(3));
    g.setColor(Color.BLUE);
    g.drawLine(r.getX1(), r.getY1(), r.getX2(), r.getY1());
    g.drawLine(r.getX1(), r.getY1(), r.getX1(), r.getY2());
    g.drawLine(r.getX2(), r.getY2(), r.getX2(), r.getY1());
    g.drawLine(r.getX2(), r.getY2(), r.getX1(), r.getY2());

    System.out.println(r.getX1() + " " + r.getY1() + " " + r.getX2());
    System.out.println("Drawn rectangle");
}

/**
 * displays last stroke of the polygon (arch between the last and first
 * vertices)
 * 
 * @param polygon
 *            to be finished
 */
public void finishPolygon(ArrayList<Point> polygon) {
    // if there are less than 3 vertices than nothing to be completed
    if (polygon.size() >= 3) {
        Point firstVertex = polygon.get(0);
        Point lastVertex = polygon.get(polygon.size() - 1);

        Graphics2D g = (Graphics2D) this.getGraphics();
        g.setColor(Color.GREEN);
        g.setStroke(new BasicStroke(3));
        g.drawLine(firstVertex.getX(), firstVertex.getY(),
                lastVertex.getX(), lastVertex.getY());
    }
}

/**
 * moves current polygon to the list of polygons and makes pace for a new
 * one
 */
public void addNewPolygon() {
    // finish the current polygon if any
    if (currentPolygon != null) {
        finishPolygon(currentPolygon);
        polygonsList.add(currentPolygon);
    }

    currentPolygon = new ArrayList<Point>();
}

public void mouseClicked(MouseEvent e) {

    if (!drawingRectangle) {
        int x = e.getX();
        int y = e.getY();

        // check if the cursor is within image area
        if (x > image.getWidth() || y > image.getHeight()) {
            // if not do nothing
            return;
        }

        Graphics2D g = (Graphics2D) this.getGraphics();

        // if the left button than we will add a vertex to poly
        if (e.getButton() == MouseEvent.BUTTON1) {
            g.setColor(Color.GREEN);
            if (currentPolygon.size() != 0) {
                Point lastVertex = currentPolygon
                        .get(currentPolygon.size() - 1);

                g.setStroke(new BasicStroke(3));
                g.drawLine(lastVertex.getX(), lastVertex.getY(), x, y);
            }
            g.fillOval(x - 5, y - 5, 10, 10);

            currentPolygon.add(new Point(x, y));
            System.out.println(x + " " + y + " polygon point");
        }
    }
}

public void mouseEntered(MouseEvent arg0) {
}

public void mouseExited(MouseEvent arg0) {
}

public void mousePressed(MouseEvent arg0) {
    if (drawingRectangle) {
        currentRectangle = new Rectangle(arg0.getX(), arg0.getY(),
                arg0.getX(), arg0.getY(), Color.BLACK);

    }
}

public void mouseReleased(MouseEvent arg0) {
    if (drawingRectangle) {
        rectangleList.add(new Rectangle(currentRectangle.getX1(),
                currentRectangle.getY1(), arg0.getX(), arg0.getY(),
                currentRectangle.getColor()));

        System.out.println(currentRectangle.getX1() + " "
                + currentRectangle.getY1() + " " + arg0.getX() + " "
                + arg0.getY() + " rectangle point");

        // unnecessary when mouseDragged calls paintComponent directly?
        /*drawRectangle(new Rectangle(currentRectangle.getX1(),
                currentRectangle.getY1(), arg0.getX(), arg0.getY(),
                currentRectangle.getColor()));*/

        currentRectangle = null;
        drawingRectangle = false;

    }
}

public void mouseDragged(MouseEvent arg0) {

    if (drawingRectangle) {
        currentRectangle = new Rectangle(currentRectangle.getX1(),
                currentRectangle.getY1(), arg0.getX(), arg0.getY(),
                currentRectangle.getColor());

        System.out.println(currentRectangle.getX1() + " "
                + currentRectangle.getY1() + " " + arg0.getX() + " "
                + arg0.getX() + " " + "Dragging");
        repaint();

    // It works better using this instead on repaint()

//           Graphics g = this.getGraphics();
//           paintComponent(g);
    }

}

public void mouseMoved(MouseEvent arg0) {
    // TODO Auto-generated method stub

}

}