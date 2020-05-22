System.out.println("OUTGOING:");
for (String city : flightsFromEachCity.keySet()) {
    String cities = flightsFromEachCity.get(city).stream().map(Flight::getCityTo).collect(Collectors.joining(" and "));
    System.out.println("- from " + city + " to " + cities);
}
System.out.println("INCOMING:");
for (String city : flightsToEachCity.keySet()) {
    String cities = flightsToEachCity.get(city).stream().map(Flight::getCityFrom).collect(Collectors.joining(" and "));
    System.out.println("- from " + cities + " to " + city);
}