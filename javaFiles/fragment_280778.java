private static int MAX_SEATS = 8;
private String[] seats = new String[MAX_SEATS];

public boolean addPassenger(String passengerName) {
    for (int i = 0; i < seats.length; i++) {
        if (seats[i] == null) {
            seats[i] = passengerName;
            return true;
        }
    }
    return false;
}