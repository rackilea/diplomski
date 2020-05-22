import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.openstreetmap.gui.jmapviewer.JMapViewer;

public class TestMapZoom {

    static class CustomMap extends JMapViewer {
        private int maxZoomLevel;

        public CustomMap() {
            this.maxZoomLevel = 7;
        }

        public int getMaxZoomLevel() {
            return maxZoomLevel;
        }

        public void setMaxZoomLevel(int maxZoom) {
            this.maxZoomLevel = maxZoom;
        }

        @Override
        public void setZoom(int zoom, Point mapPoint) {
            if (zoom < getMaxZoomLevel())
                super.setZoom(zoom, mapPoint);
        }
    }

    private static void createAndShowUI() {
        JFrame frame = new JFrame("Demo");
        CustomMap viewer = new CustomMap();

        frame.add(viewer);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowUI();
            }
        });
    }
}