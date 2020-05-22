import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.DefaultMapController;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;

public class Map3 extends JMapViewer{
private double lat, lon;

public Map3() 
{
   new DefaultMapController(this) {
        public void mouseClicked(MouseEvent e) {
            System.out.println(e.getPoint());
            Point  p = e.getPoint();
            lat = map.getPosition(p).getLat();
            lon = map.getPosition(p).getLon();
        }};
  }

protected void paintComponent(Graphics g){
    super.paintComponent(g);
    Coordinate c1= new Coordinate(lat,lon),c2= new Coordinate(lat+10,lon+10);
    List<Coordinate> route = new ArrayList<Coordinate>(Arrays.asList(c1, c2, c1));
    this.addMapPolygon(new MapPolygonImpl(route));
}   

public static void main (String [] args){
            JFrame jf = new JFrame();
            jf.setSize(800, 600);
            Map3 m= new Map3();
            jf.add(m);
            jf.setVisible(true);
    }
}