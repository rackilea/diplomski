public class Plane {

    private Seat[] seats;

    public Plane(int capacity) {
        this.seats = new Seat[capacity];
        for (int i = 0; i < seats.length; i++) {
            seats[i] = new Seat();
        }
    }

    public boolean addPassenger(Passenger passenger) {
        for (Seat seat : seats) {
            if (!seat.isOccupied()) {
                seat.setPassenger(passenger);
                return true;
            }
        }
        return false;
    }

    public boolean addPassengers(Passenger... passengers) {
        if (passengers == null) {
            throw new IllegalArgumentException("Passengers cannot be null");
        }
        if (!hasFreeSeats(passengers.length)) {
            return false;
        } else {
            for (Passenger passenger : passengers) {
                addPassenger(passenger);
            }
            return true;
        }
    }

    private boolean hasFreeSeats(int count) {
        int seatsNeeded = count;
        for (Seat seat : seats) {
            if (!seat.isOccupied()) {
                seatsNeeded--;
            }
            if (seatsNeeded == 0) {
                return true;
            }
        }
        return false;
    }

}

public class Seat {

    private Passenger passenger;

    public boolean isOccupied() {
        return passenger != null;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    // getter for passenger and other fields   
}

public class Passenger {

    private final String name;

    public Passenger(String name) {
        this.name = name;
    }

    // getter for name and other fields
}