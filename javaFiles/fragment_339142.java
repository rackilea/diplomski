package org.bar;

import org.geotools.referencing.GeodeticCalculator;
import java.awt.geom.Point2D;

/**
 * How far is NY from London ?
 */
public class DistanceTest {

  public final static void main(final String[] args) {
    final GeodeticCalculator calc = new GeodeticCalculator();

    final Point2D london = new Point2D.Double(-0.127512, 51.507222);
    final Point2D ny = new Point2D.Double(-73.94, 40.67 );
    calc.setStartingGeographicPoint(london);
    calc.setDestinationGeographicPoint(ny);

    System.out.println("Distance London-NY: " + calc.getOrthodromicDistance()/1000 + " kms");
  }

}