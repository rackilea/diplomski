public void update(Observable flight, Object flightStatusEvent) {

        FlightStatusChangeEvent fsce = (FlightStatusChangeEvent) flightStatusEvent;
        Flight fl = fsce.getFlight();
        String code = fl.getFlightCode();
        int status = fsce.getStatus();

        // find the flight in array flights and then update its status
        for (int i = 0; i < flights.size(); i++) {

            Flight fli = flights.get(i);
            String flCode = fli.getFlightCode();

            if (flCode.equals(code)) {
                // THIS WILL CAUSE STACKOVERFLOWERROR
                fli.updateStatus(status);
                System.out.print("Flight status updated !");

                break;

            }

        }

    }