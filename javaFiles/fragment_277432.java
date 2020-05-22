package polygonexample;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ndunn
 */
public class PolygonExample extends JPanel {

    private static final int NUM_POLYGONS = 20;

    private List<MapPolygon> polygons;

    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private Random random = new Random();
    public PolygonExample() {

        polygons = new LinkedList<MapPolygon>();
        for (int i = 0; i < NUM_POLYGONS; i++) {
            int x1 = random.nextInt(WIDTH);
            int x2 = random.nextInt(WIDTH);
            int x3 = random.nextInt(WIDTH);

            int y1 = random.nextInt(HEIGHT);
            int y2 = random.nextInt(HEIGHT);
            int y3 = random.nextInt(HEIGHT);

            int r = random.nextInt(255);
            int g = random.nextInt(255);
            int b = random.nextInt(255);
            Color randomColor = new Color(r,g,b);

            polygons.add(new MapPolygon(new int[]{x1,x2,x3}, new int[]{y1,y2,y3}, 3, randomColor));
        }

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                for (MapPolygon mapPiece : polygons) {
                    if (mapPiece.contains(e.getPoint())) {
                        mapPiece.setSelected(!mapPiece.isSelected());
                        repaint();
                        break;
                    }
                }
            }
        });
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        final Color outlineColor = Color.BLACK;
        for (MapPolygon mapPiece : polygons) {
            if (mapPiece.isSelected()) {
                g.setColor(mapPiece.getFillColor());
                g.fillPolygon(mapPiece);
            }
            else {
                g.setColor(outlineColor);
                g.drawPolygon(mapPiece);
            }
        }
    }



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new PolygonExample();
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class MapPolygon extends Polygon {

        private boolean selected;
        private Color fillColor;

        public MapPolygon(int[] xpoints, int[] ypoints, int npoints, Color color) {
            super(xpoints, ypoints, npoints);
            this.fillColor = color;
            this.selected = false;
        }

        public Color getFillColor() {
            return fillColor;
        }

        public void setFillColor(Color fillColor) {
            this.fillColor = fillColor;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }
    }

}