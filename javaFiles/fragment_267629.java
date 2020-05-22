public class Location {
    private Double lat;
    private Double lng;

    // Constructors, getters, setters
}

public class Geometry {
    private Location location;

    // Constructors, getters, setters
}

public class GeoResult {
    private String id;
    private Geometry geometry;
    private String name;

    // Constructors, getters, setters
}

public class DataWrapper {
    private List<GeoResult> results;

    // Constructors, getters, setters
}