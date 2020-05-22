public String rooms( ) {
    // declare your String locally, not globally in the class
    String output = "House Rooms included in tour\n";
    // again, avoid using "magic" numbers like 7
    for (int i = 0; i < rooms.length; i++) {
        output += rooms[i].toString(); // **** you must extract Room's String
    }
    return output;  // no need to call toString() on a String
}