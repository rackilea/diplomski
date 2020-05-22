import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

/* This program create a graphics component that draws a polygon 
 */
public class SelectShape extends JPanel {

    // Constants
    private static final int[] x = { 20, 40, 50, 65, 80, 95 }; // Co-ords for a polygon
    private static final int[] y = { 60, 105, 105, 110, 95, 95 };

    private static final Polygon POLYGON = new Polygon(x, y, Math.min(x.length, y.length));
    private static final Ellipse2D CIRCLE = new Ellipse2D.Double(100, 40, 45, 45);

    // Class variables
    private final Shape shape;
    private Dimension preferredSize;

    public SelectShape(Shape shape) {
        this.shape = shape;
        Rectangle bounds = shape.getBounds();
        this.preferredSize = new Dimension(bounds.x + bounds.width, bounds.y + bounds.height);
    }

    @Override
    public Dimension getPreferredSize() {
        return preferredSize;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g.setColor(Color.BLUE);
        g2.draw(shape);
        g2.fill(shape);
    }

    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame mainFrame = new JFrame("Program");
                mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                SelectShape polygon = new SelectShape(POLYGON);
                SelectShape circle = new SelectShape(CIRCLE);
                // Create a tabbed pane
                JTabbedPane tabbedPane = new JTabbedPane();
                tabbedPane.addTab("Polygon", polygon);
                tabbedPane.addTab("Circle", circle);
                mainFrame.add(tabbedPane);
                mainFrame.pack();
                mainFrame.setVisible(true);
            }
        });

    }
}