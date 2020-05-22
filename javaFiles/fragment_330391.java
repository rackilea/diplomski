ArrayList<Polygon> polygons = new ArrrayList<Polygon>;
...
for (double [] region : regionArray) {
    Polygon polygon = new Polygon();
    polygon.getPoints().addAll(region);
    polygons.add(polygon);
 }