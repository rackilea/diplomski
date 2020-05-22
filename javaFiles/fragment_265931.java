//define a class to conform with OOP stuff
public static class Coordinate {

    private final Double lat;
    private final Double lon;
    private final Integer type;
    private final Double distance;

    public Coordinate(Double lat, Double lon, Integer type, Double distance){
        this.lat = lat;
        this.lon = lon;
        this.type = type;
        this.distance = distance;
    }

    public Double getDistance() {
        return distance;
    }
}

// define a conversion logic
private static Coordinate convert(JSONObject raw){
    Double distance = Double.valueOf((String) raw.get("distance"));
    Double lon = Double.valueOf((String) raw.get("lon"));
    Double lat = Double.valueOf((String) raw.get("lat"));
    Integer type = Integer.valueOf((String) raw.get("type"));
    return new Coordinate(lat, lon, type, distance);
}