import java.awt.event.MouseWheelEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.openstreetmap.gui.jmapviewer.DefaultMapController;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MemoryTileCache;

public class TestMapZoom2 {

    static class CustomMapController extends DefaultMapController {
        private int maxZoomLevel;

        public CustomMapController(JMapViewer map) {
            super(map);
            this.maxZoomLevel = 7;
        }

        public int getMaxZoomLevel() {
            return maxZoomLevel;
        }

        public void setMaxZoomLevel(int maxZoom) {
            this.maxZoomLevel = maxZoom;
        }

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) { 
            if (e.getWheelRotation() < 0 && map.getZoom() >= getMaxZoomLevel())
                return;
            super.mouseWheelMoved(e);   
        }
    }

    private static void createAndShowUI() {
        JFrame frame = new JFrame("Demo");
        JMapViewer viewer = new JMapViewer(new MemoryTileCache(), 8);
        new CustomMapController(viewer);

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