class Airlines {
    public static void main(String args[]) throws Exception{
        ArrayList<Flight> flights = new ArrayList<>();
        flights.add(new Flight("Moskwa", "Londyn", 140, 524));
        flights.add(new Flight("Warszawa", "Wroclaw", 60, 135));
        flights.add(new Flight("Frankfurt", "Rzym", 95, 141));

        Scanner flightNumber = new Scanner(System.in);
        System.out.println("Enter code of your flight: ");
        int flightNumber_go = Integer.valueOf(flightNumber.nextLine());
        Flight currentFlight = findFlight(flights, flightNumber_go);
        System.out.println(currentFlight.getParameters());

    }

    public static Flight findFlight(ArrayList<Flight> flights, int flightNum) {
        for (Flight f : flights) {
            if (f.getFlightNum() == flightNum) {
                return f;
            }
        }
        //If no flights are found
        return null;
   }
}