//distacne in meters which was calucletd 
public Point interpolatePointAlogLine(LineString line,double distance) throws 
   NoSuchAuthorityCodeException, FactoryException
{       
    GeodeticCalculator calculator = new GeodeticCalculator(CRS.decode("EPSG:4326")); 
    GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(PrecisionModel.FLOATING), 4326);

    List<Coordinate> coordinates = new ArrayList<Coordinate>();
    Collections.addAll(coordinates, line.getCoordinates());
    double accumulatedLength = 0;

    if(distance >= line.getLength())
        return geometryFactory.createPoint(line.getEndPoint());

    for (int i = 0; i < coordinates.size(); i++)
    {

        Coordinate c1 = coordinates.get(i);
        Coordinate c2 = coordinates.get(i + 1);

        calculator.setStartingGeographicPoint(c1.x, c1.y);
        calculator.setDestinationGeographicPoint(c2.x, c2.y);

        double length = calculator.getOrthodromicDistance();

        if (length + accumulatedLength >= distance) 
        {
            double offsetLength = distance - accumulatedLength;
            double ratio = offsetLength / length;
            double dx = c2.x - c1.x;
            double dy = c2.y - c1.y;

            Coordinate iPoint = new Coordinate(c1.x + (dx * ratio), 
                    c1.y + (dy * ratio));

            return geometryFactory.createPoint(iPoint));
        }
        else {
            accumulatedLength += length;
        }
    }
    return null;
}