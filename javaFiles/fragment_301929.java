import java.awt.Dimension;
import java.awt.geom.Point2D;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import edu.umd.cs.piccolo.PCanvas;
import edu.umd.cs.piccolo.PLayer;
import edu.umd.cs.piccolo.event.PBasicInputEventHandler;
import edu.umd.cs.piccolo.event.PInputEvent;
import edu.umd.cs.piccolo.nodes.PPath;

public class TestZoom {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {   
            public void run() {   
                JFrame frame = new JFrame("TestZoom");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationByPlatform(true);

                final PCanvas canvas = new PCanvas() {
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(300, 300);
                    }
                };

                PLayer layer = new PLayer();
                canvas.getCamera().addLayer(0, layer);
                canvas.getCamera().getRoot().addChild(layer);

                final PPath node = PPath.createRectangle(100, 100, 100, 100);
                canvas.getLayer().addChild(node);

                canvas.addInputEventListener(new MouseZoomHandler());

                frame.add(canvas);            
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public static class MouseZoomHandler extends PBasicInputEventHandler {
        @Override
        public void mouseWheelRotated(final PInputEvent event) {
            final double scale = 1 - 0.2 * event.getWheelRotation(); 
            final Point2D point = event.getPosition();
            event.getCamera().scaleViewAboutPoint(scale, 
                    point.getX(), point.getY());                
        }
    }
}