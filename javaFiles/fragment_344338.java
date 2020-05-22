package com.example.mapping;

import java.util.Random;

public class TestRandomCityLocation {
    // Class fields
    private static TestRandomCityLocation me;
    private static final String[] defaultArguments = { "" };

    // Object fields

    public static void main(String[] args) {
        String[] arguments;

        me = new TestRandomCityLocation();
        if (args == null || args.length == 0) {
            arguments = defaultArguments;
        } else {
            arguments = args;
        }

        me.doWork(arguments);

    }

    private void doWork(String[] arguments) {
        int maximumPoints = 100;
        GeographicPoint newLocation;

        GeographicSquare mockCityGeo = new GeographicSquare(
                new GeographicPoint(38.7, -77.0), new GeographicPoint(38.9,
                        -76.9));
        String cityName = "Google Maps city name";

        Random randomGenerator = new Random();

        double deltaLong = mockCityGeo.getDeltaLongitude();
        double deltaLat = mockCityGeo.getDeltaLatitude();

        for (int i = 0; i < maximumPoints; i++) {
            newLocation = new GeographicPoint(
                    mockCityGeo.getLowerLeftLatitude() + deltaLat
                            * randomGenerator.nextDouble(),
                    mockCityGeo.getLowerLeftLongitude() + deltaLong
                            * randomGenerator.nextDouble());

            // TODO test to see of newLocation is in the city
            if (GoogleMapInfo.isWithinCity(cityName, newLocation)) {
                // TODO Do something
            }

        }
    }

}