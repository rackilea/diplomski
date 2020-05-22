import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Arc2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Polygon extends JPanel {
    private static final int RADIUS = 20;

    private final int[] xpoints = {
            10, 150, 80, 60
    };
    private final int[] ypoints = {
            10, 10, 150, 60
    };
    final Arc2D[] arcs;

    Polygon() {
        arcs = new Arc2D[xpoints.length];
        for (int i = 0; i < arcs.length; i++) {
            // Indices of previous and next corners
            int prev = (i + arcs.length - 1) % arcs.length;
            int next = (i + arcs.length + 1) % arcs.length;
            // angles of sides, pointing outwards from the corner
            double ang1 = Math.toDegrees(Math.atan2(-(ypoints[prev] - ypoints[i]), xpoints[prev] - xpoints[i]));
            double ang2 = Math.toDegrees(Math.atan2(-(ypoints[next] - ypoints[i]), xpoints[next] - xpoints[i]));
            int start = (int) ang1;
            int extent = (int) (ang2 - ang1);
            // always draw to positive direction, limit the angle <= 360
            extent = (extent + 360) % 360;
            arcs[i] = new Arc2D.Float(xpoints[i] - RADIUS, ypoints[i] - RADIUS, 2 * RADIUS, 2 * RADIUS, start, extent, Arc2D.OPEN);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(160, 160);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawPolygon(xpoints, ypoints, xpoints.length);
        Graphics2D g2d = (Graphics2D) g;
        for (Shape s : arcs) {
            g2d.draw(s);
        }
    }

    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Polygon");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new Polygon());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}