import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerCircle;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.Style;

/**
 * @see http://stackoverflow.com/a/33857113/230513
 */
public class London {

    private static final Random r = new Random();

    private void display() {
        JFrame f = new JFrame("London");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMapViewer map = new JMapViewer() {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(320, 240);
            }
        };
        Coordinate london = new Coordinate(51.5072, -0.1275);
        map.setDisplayPosition(london, 16);
        MyMarker dot = new MyMarker("", london);
        map.addMapMarker(dot);
        map.addMapMarker(new MapMarkerDot("London", london));
        f.add(map);
        f.add(new JButton(new AbstractAction("Update") {

            @Override
            public void actionPerformed(ActionEvent e) {
                Style style = dot.getStyle();
                style.setBackColor(Color.getHSBColor(r.nextFloat(), 1f, 1f));
                style.setColor(Color.red);
                map.repaint();
            }
        }), BorderLayout.SOUTH);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static class MyMarker extends MapMarkerCircle {

        public MyMarker(String name, Coordinate coord) {
            super(null, name, coord, 12, STYLE.FIXED, getDefaultStyle());
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new London()::display);
    }
}