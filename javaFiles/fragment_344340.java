package com.example.mapping;

public class GeographicPoint {
    // Object fields
    private double latitude; 
    private double longitude;

    public GeographicPoint(double latitudeDegrees, double  longitudeDegrees) {
        this.latitude = latitudeDegrees;
        this.longitude = longitudeDegrees;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    /** Distance calculation using Haversine formula to calculate a great-circle distance 
     * between two points of the surface of the earth.
     * 
     * formula: a = sin²(Δφ/2) + cos φ1 ⋅ cos φ2 ⋅ sin²(Δλ/2)
     * c = 2 ⋅ atan2( √a, √(1−a) )
     * d = R ⋅ c
        where   φ is latitude, λ is longitude, R is earth’s radius 
        (mean radius = 3958,756 miles (6,371km));
        Note bene: angles must be in radians to pass to trig functions!
     * @param location
     * @return
     */
    public double milesFrom(GeographicPoint location) {

        double rInMiles = 3958.756;
        double lat1Radians = radiansFromDegrees(latitude);
        double lat2Radians = radiansFromDegrees(location.getLatitude());
        double deltaLat = radiansFromDegrees(location.getLatitude()-latitude);
        double deltaLong = radiansFromDegrees(location.getLongitude()-longitude);

        double a = Math.sin(deltaLat/2.0) * Math.sin(deltaLat/2.0) +
                   Math.cos(lat1Radians) * Math.cos(lat2Radians) * Math.sin(deltaLong/2.0)*Math.sin(deltaLong/2.0);
        double c = 2.0 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double d = rInMiles * c;

        return d;

    }

    public double getLatitudeDifference(GeographicPoint location) {
        return Math.abs(latitude - location.getLatitude());
    }
    public double getLongitudeDifference(GeographicPoint location) {
        return Math.abs(longitude - location.getLongitude());
    }
    public GeographicPoint getOffsetPoint(double latitudeOffset, double longitudeOffset) {
        return new GeographicPoint(latitude+latitudeOffset, longitude+longitudeOffset);
    }
    // Internal methods

    private double radiansFromDegrees(double degrees) {
        return (degrees * Math.PI) / 180.0;
    }
}