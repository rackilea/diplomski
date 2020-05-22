Vector routeLayer = new Vector("route");

List<Point> pointList = new ArrayList<Point>();
Projection defaultProj = new Projection(DEFAULT_PROJECTION); 
  // DEFAULT_PROJECTION = "EPSG:4326"
Projection mapProj = new Projection(mapWidget.getMap().getProjection());
for (String coord : KML.split(" "))
{
  String[] xyz = coord.split(",");
  if (xyz.length == 3)
  {
    Point point = new Point(Double.parseDouble(xyz[0]), Double.parseDouble(xyz[1]));
      // lon,lat 
    point.transform(defaultProj, mapProj);
    pointList.add(point);
  }
}
LineString geometry = new LineString(pointList.toArray(new Point[pointList.size()]));
Style style = new Style();
style.setStrokeColor("#0033ff");
style.setStrokeWidth(5);

routeLayer.addFeature(new VectorFeature(geometry, style));

mapWidget.getMap().addLayer(routeLayer);