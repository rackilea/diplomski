for (int i = 0; i < airplaneRef.length; i++) { // for i, if i is less than the length of the array airplaneRef, increment i.
    if (airplaneRef[i].equalsIgnoreCase(passengerName)) { // iterates through all elements in the array, ignoring case sensitivity and looks for the passenger.
        int seat = i;
        System.out.println(passengerName + " is sitting in seat s" + seat); // prints name of passenger and what seat they are sitting in.
        return;
    }
}
System.out.println("Passenger not found.");