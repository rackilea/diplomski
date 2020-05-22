import com.javadocmd.simplelatlng.LatLng;
import com.javadocmd.simplelatlng.LatLngTool;
import com.javadocmd.simplelatlng.util.LengthUnit;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class GridMap {
private double lat_rad;
private double lng_rad;
private Polygon grid;
private double factor = 100000;
private List<LatLng> bounds = new LinkedList<>();

public GridMap(int lat_bin, int lng_bin, List<Double> coords) {
    // coords should be (y_bot, x_bot;,y_up, x_bot;y_up, x_up;y_bot, x_up)
    grid = new Polygon();
    for (int i = 0; i < coords.size(); i += 2) {
        int nx = (int) Math.floor(factor * coords.get(i));
        int ny = (int) Math.floor(factor * coords.get(i + 1));
        grid.addPoint(nx, ny);
        bounds.add(new LatLng(coords.get(i), coords.get(i + 1)));
    }
    lat_rad = LatLngTool.distance(bounds.get(0), bounds.get(1), LengthUnit.METER) / (lat_bin);
    lng_rad = LatLngTool.distance(bounds.get(0), bounds.get(3), LengthUnit.METER) / (lng_bin);
}

public boolean inGrid(LatLng point) {
    int lat = (int) Math.floor(factor * point.getLatitude());
    int lng = (int) Math.floor(factor * point.getLongitude());
    return grid.contains(lat, lng);
}

public Point toGrid(LatLng llp) {
    if (inGrid(llp)) {
        double lat = llp.getLatitude();
        double lng = llp.getLongitude();
        double rel_lat = bounds.get(0).getLatitude();
        double rel_lng = bounds.get(0).getLongitude();
        int ilat = (int) Math.floor(LatLngTool.distance(new LatLng(rel_lat, lng), bounds.get(0), LengthUnit.METER) / lat_rad);
        int ilng = (int) Math.floor(LatLngTool.distance(new LatLng(lat, rel_lng), bounds.get(0), LengthUnit.METER) / lng_rad);
        return new Point(ilat, ilng);
    }
    return new Point(-1, -1);
}

public LatLng toLatLng(Point gridLoc){
    double lat_dist = (gridLoc.getY() + 0.5) * lat_rad;
    double lng_dist = (gridLoc.getX() + 0.5) * lng_rad;
    double y_bearing = LatLngTool.initialBearing(bounds.get(0), bounds.get(1));
    double x_bearing = LatLngTool.initialBearing(bounds.get(1), bounds.get(2));
    LatLng startLatLng = new LatLng(bounds.get(0).getLatitude(), bounds.get(0).getLongitude());
    LatLng lat_llp = LatLngTool.travel(startLatLng, y_bearing, lat_dist, LengthUnit.METER);
    return LatLngTool.travel(lat_llp, x_bearing, lng_dist, LengthUnit.METER);
}
}