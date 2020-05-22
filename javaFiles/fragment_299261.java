public String toString() {
    String s = "Building size" + xSize + ", " + ySize;
    for (Room r : allRooms) {
        s += r.toString();
    }
    return s;  
}