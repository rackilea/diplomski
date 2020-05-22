package ndd;

public class RadiusBox {
    static final Double kEarthRadiusMiles = 3956.0;
    public static RadiusBox create(Double latitude, Double longitude, Double radiusInMiles)
    {
        /*
            A point {lat,lon} is a distance d out on the tc radial from point 1 if:

            lat = asin (sin (lat1) * cos (d) + cos (lat1) * sin (d) * cos (tc))
            dlon = atan2 (sin (tc) * sin (d) * cos (lat1), cos (d) - sin (lat1) * sin (lat))
            lon = mod (lon1 + dlon + pi, 2 * pi) - pi

            Where:
                * d is the distance in radians (an arc), so the desired radius divided by
                    the radius of the Earth.
                * tc = 0 is N, tc = pi is S, tc = pi/2 is E, tc = 3*pi/2 is W.
        */
        double lat;
        double dlon;
        double dLatInRads = latitude * (Math.PI / 180.0);
        double dLongInRads = longitude * (Math.PI / 180.0);
        double dDistInRad = radiusInMiles / kEarthRadiusMiles;
        RadiusBox box = new RadiusBox ();
        box.setRadius(radiusInMiles);

        //  N (tc == 0):
        //      lat = asin (sin(lat1)*cos(d) + cos(lat1)*sin(d))
        //          = asin (sin(lat1 + d))
        //          = lat1 + d
        //  Unused:
        //      lon = lon1, because north-south lines follow lines of longitude.
        box.setTopLine((dLatInRads + dDistInRad) * (180.0 / Math.PI));

        //  S (tc == pi):
        //      lat = asin (sin(lat1)*cos(d) - cos(lat1)*sin(d))
        //          = asin (sin(lat1 - d))
        //          = lat1 - d
        //  Unused:
        //      lon = lon1, because north-south lines follow lines of longitude.
        box.setBottomLine((dLatInRads - dDistInRad) * (180.0 / Math.PI));

        //  E (tc == pi/2):
        //      lat  = asin (sin(lat1)*cos(d))
        //      dlon = atan2 (sin(tc)*sin(d)*cos(lat1), cos(d) - sin(lat1)*sin(lat))
        //      lon  = mod (lon1 + dlon + pi, 2*pi) - pi
        lat = Math.asin (Math.sin(dLatInRads) * Math.cos (dDistInRad));
        dlon = Math.atan2 (Math.sin(Math.PI / 2.0) * Math.sin (dDistInRad) * Math.cos (dLatInRads), Math.cos (dDistInRad) - Math.sin (dLatInRads)* Math.sin (lat));
        box.setRightLine( (((dLongInRads + dlon + Math.PI) % (2.0 * Math.PI)) - Math.PI) * (180.0 / Math.PI));

        //  W (tc == 3*pi/2):
        //      lat  = asin (sin(lat1)*cos(d))
        //      dlon = atan2 (sin(tc)*sin(d)*cos(lat1), cos(d) - sin(lat1)*sin(lat))
        //      lon  = mod (lon1 + dlon + pi, 2*pi) - pi
        dlon = Math.atan2 (Math.sin (3.0 * Math.PI / 2.0) * Math.sin (dDistInRad) * Math.cos (dLatInRads), Math.cos (dDistInRad) - Math.sin (dLatInRads)* Math.sin (lat));
        box.setLeftLine((((dLongInRads + dlon + Math.PI) % (2.0 * Math.PI)) - Math.PI) * (180.0 / Math.PI));

        return box;
    }

    private double bottomLine;
    private double topLine;
    private double leftLine;
    private double rightLine;
    private double radius;
    public double getBottomLine() {
        return bottomLine;
    }
    public void setBottomLine(double bottomLine) {
        this.bottomLine = bottomLine;
    }
    public double getTopLine() {
        return topLine;
    }
    public void setTopLine(double topLine) {
        this.topLine = topLine;
    }
    public double getLeftLine() {
        return leftLine;
    }
    public void setLeftLine(double leftLine) {
        this.leftLine = leftLine;
    }
    public double getRightLine() {
        return rightLine;
    }
    public void setRightLine(double rightLine) {
        this.rightLine = rightLine;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    @Override
    public String toString() {
        return "RadiusBox [bottomLine=" + bottomLine + ", leftLine=" + leftLine
                + ", radius=" + radius + ", rightLine=" + rightLine
                + ", topLine=" + topLine + "]";
    }

    public String getSqlQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append ("SELECT * FROM ZIP_CODES WHERE ");
        sb.append ("LATITUDE >= ");
        sb.append(bottomLine);
        sb.append (" AND LATITUDE <= ");
        sb.append(topLine);
        sb.append (" AND LONGITUDE >= ");
        sb.append(leftLine);
        sb.append (" AND LONGITUDE <= ");
        sb.append(rightLine);
        sb.append (" ORDER BY CITY, STATE, ZIP");
        return sb.toString();
    }
}