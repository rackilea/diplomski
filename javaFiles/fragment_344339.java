package com.example.mapping;

public class GeographicSquare {
    // Object fields
    private GeographicPoint lowerLeft;
    private GeographicPoint upperRight;
    public GeographicSquare (GeographicPoint lowerLeft, GeographicPoint upperRight) {
        this.lowerLeft = lowerLeft;
        this.upperRight = upperRight;
    }
    public double getDeltaLongitude() {
        return lowerLeft.getLongitudeDifference(upperRight);
    }
    public double getDeltaLatitude() {
        return lowerLeft.getLatitudeDifference(upperRight);
    }
    public double getLowerLeftLongitude() {
        return lowerLeft.getLongitude();
    }
    public double getLowerLeftLatitude() {
        return lowerLeft.getLatitude();
    }
}