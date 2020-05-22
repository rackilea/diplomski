private void checkConflicts(ArrayList<Flight> flightsInArea) {
  HashSet<Integer> redFlights = new HashSet<Integer>();

  // Check for red flights
  for (int i = 0; i < flightsInArea.size(); i++) {
    for (int j = i + 1; j < flightsInArea.size(); j++) {
      Coordinate currentFlight1 = flightsInArea.get(i).getCurrentPosition();
      Coordinate currentFlight2 = flightsInArea.get(j).getCurrentPosition();

      double cathetusX = Math.pow((currentFlight1.getPositionX() - currentFlight2.getPositionX()), 2);
      double cathetusY = Math.pow((currentFlight1.getPositionY() - currentFlight2.getPositionY()), 2);

      double distance = Math.sqrt(cathetusX + cathetusY);

      if (distance < 100) {
        redFlights.add(i);
        redFlights.add(j);
      }
    }
  }

  // Mark flights
  for (int i = 0; i < flightsInArea.size(); i++) {
    flightsInArea.get(i).establishImage(redFlights.contains(i));
  }
}