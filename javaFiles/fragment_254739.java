// From ScankortDenmark example
public static double computeZoomForExtent(Sector sector)
{
    Angle delta = sector.getDeltaLat();
    if (sector.getDeltaLon().compareTo(delta) > 0)
        delta = sector.getDeltaLon();
    double arcLength = delta.radians * Earth.WGS84_EQUATORIAL_RADIUS;
    double fieldOfView = Configuration.getDoubleValue(AVKey.FOV, 45.0);
    return arcLength / (2 * Math.tan(fieldOfView / 2.0));
}