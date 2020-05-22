ArrayList<Coordinate> points = new ArrayList<Coordinate>();
  points.add(new Coordinate(longitude, latitude));
  ...  
  points.add(new Coordinate(lon, lat));
  ...
  //make sure to close the linear ring
  points.add(new Coordinate(longitude, latitude));
  poly = geometryFactory.createPolygon((Coordinate[]) points.toArray(new Coordinate[] {}));
  valid = poly.isValid();