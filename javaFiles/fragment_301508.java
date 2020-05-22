public class Coordinates {
  public final double lat;
  public final double lng;

  public Coordinates(double lat, double lng) {
    this.lat = lat;
    this.lng = lng;
  }

  public Coordinates translate(double dlat, double dlng) {
      return new Coordinates(..., ...);
  }
}

BiFunction<Coordinates, Coordinates, Coordinates> f = Coordinates::translate;
Coordinates c1 = f.apply(c2, c3);