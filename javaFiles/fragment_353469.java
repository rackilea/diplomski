public final class IsSameLatLong extends ArgumentMatcher<GeoPoint> {

  private final GeoPoint as;

  public IsSameLatLong(GeoPoint as) {
      this.as = as;
  }

  //some sensible value, like 1000th of a second i.e. 0° 0' 0.001"
  private final static double EPSILON = 1.0/(60*60*1000); 

  private static boolean closeEnough(double a, double b) {
     return Math.abs(a - b) < EPSILON;
  }

  public boolean matches(Object point) {
      GeoPoint other = (GeoPoint) point;
      if (other == null) return false;
      return closeEnough(other.getLat(), as.getLat()) &&
             closeEnough(other.getLong(), as.getLong());
  }
}