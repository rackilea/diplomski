import java.util.*;
import java.awt.geom.*;

public class LatLong {

        private  int  imageW,  imageH;
        private final static   double   west = -79.974642,      north = 39.647556,
                                        east = -79.971244,      south = 39.644675;

        public LatLong (int w, int h) {
                imageW = w;
                imageH = h;
        }

        public List<Point2D> convertLatLongToCoord (List<Point2D> coordinate) {
            List<Point2D> latLong = new ArrayList<Point2D>();
            for (Point2D coord : coordinate) {
                double  x = coord.getY(),       px = imageW * (x-east) / (west-east),
                        y = coord.getX(),       py = imageH * (y-north)/(south-north);
                latLong.add (new Point2D.Double(px,py));
            }
            return latLong;
        }

        public static void main (String[] args) {
                double[] latit = {39.64581, 39.64651, 39.646915, 39.646538, 39.646458},
                        longit = {-79.97168, -79.97275, -79.97342, -79.97279, -79.97264};

                List<Point2D> pointList = new ArrayList<Point2D>();
                for (int i = 0 ; i < latit.length ; i++)
                        pointList.add (new Point2D.Double(latit[i], longit[i]));

                List<Point2D> pixels = new LatLong (800,600).convertLatLongToCoord (pointList);

                for (int i = 0 ; i < latit.length ; i++)
                        System.out.println ("[" + (i+1) + "]\t(" + latit[i] + "," + longit[i] + ") -> " +
                                (int) (pixels.get(i).getX()) + "," + (int) (pixels.get(i).getY()));
}}