package com.techtrip.labs.stackoverflow;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class CoordinateFactory {

    public List<Coordinate> getCoordinates(List<String[]> raw) {
        List<Coordinate> coordinates = new ArrayList<Coordinate>(raw.size());

        for (String[] row : raw) {
            coordinates.add(createCoordinate(row));
        }

        return coordinates;

    }

    private Coordinate createCoordinate(String... args) {
        // add error checking here as an assignment
        Coordinate coordinate = new Coordinate();

        coordinate.setTimeStamp(parseToLocalDateTime(args[0]));
        coordinate.setLongitude(Double.parseDouble(args[1]));
        coordinate.setLatitude(Double.parseDouble(args[2]));
        coordinate.setElevation(Double.parseDouble(args[3]));
        return coordinate;
    }

    private ZonedDateTime parseToLocalDateTime(String timeStamp) {
        // SEE Java 8 API Documentation on how to
        // Parse your date into a proper date time format

        /*
         * Let as assignment for ops
         * http://docs.oracle.com/javase/8/docs/api/java
         * /time/format/DateTimeFormatter.html
         * http://docs.oracle.com/javase/8/docs/api/java/time/ZonedDateTime.html
         */

        return null;
    }
}