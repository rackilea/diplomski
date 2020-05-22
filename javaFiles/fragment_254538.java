double speed = Double.parseDouble(tokens[5].trim()); // fifth token is speed?

if(speed < 5) {
    /* Longitude (= x coord) first ! */
    Point point = geometryFactory.createPoint(new Coordinate(longitude, latitude));

    /*add features .... */
}