public void setBuilding(String bS) {
    String[] Space;     
    allRooms.clear();
    Space = bS.split(";");

    //Here we'll update the requested building size
    String[] buildingSize = Space[0].split(" "); //split the two integers
    xSize = Integer.ParseInt(buildingSize[0]); //transform the string to int
    ySize = Integer.ParseInt(buildingSize[1]); //transform the string to int

    allRooms.add(new Room(Space[1]));
    allRooms.add(new Room(Space[2]));
    allRooms.add(new Room(Space[3]));
}