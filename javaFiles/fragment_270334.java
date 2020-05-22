public List<String> getFlight() throws Exception {

    Flight nextFlight = new Flight();
    AvailableFlights todayFlight = new AvailableFlights();
    List<Flight> flights_today =  todayFlight.getFlightDetail();

    // Since you you List for Flight, why not here
    List<String> flights = new ArrayList<String>(); 

    try {
        flights_today = readFlight.unmarshal(new File("Flights.xml"));

        for (Flight flight : flights_today) {
            String flightDetail = flight.getJourney() 
                    + " " + flight.getAirline() 
                    + " "+ String.valueOf(flight.getConnections())
                    + " "+ String.valueOf(flight.getCost())
                    + " "+ flight.getDestination()
                    + " "+ flight.getOrigin()
                    + " "+ String.valueOf(flight.getSeats());
            flights.add(flightDetail);
        }
      } catch (Exception e) {

      }

    return flights;
 }