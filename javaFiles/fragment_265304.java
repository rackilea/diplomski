for (ViewFlightRouteAirportType associatedAirportType : etopsAndNonEtopsAssociatedAirportTypes) {
    flightRoute.getAirportsForType(associatedAirportType).stream()
            .flatMap(Collection::stream)
            .filter(airport -> airportIataCode.equals(airport.getIataCode()))
            .forEach(airport -> addValueIfNotPresent(associatedFlights, associatedAirportType, flightData));
}