// User.toString
@Override
public String toString() {
    StringBuilder retVal = new StringBuilder("User{" +
            "name='" + name + '\'' +
            ", bookedSeats=[");
    for (int i = 0 ; i < bookedSeats.size() ; i++) {
        retVal.append("Booking ");
        retVal.append(i + 1);
        retVal.append(": ")
        retVal.append(bookedSeats.get(i));
        retVal.append("\n");
    }
    retVal.append("]\n}");
    return retVal.toString();

}

// BookedSeat.toString
@Override
public String toString() {
    return "Hours: " + h +
            ", Days: " + d +
            ", Hall Number: " + hallNumber +
            ", Seat Number: " + seatNumber;
}