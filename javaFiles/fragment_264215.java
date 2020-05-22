for (int floor=0; floor<hotelBuild.length; floor++){
    for (int room=0; room<hotelBuild[floor].length; room++){
        Room r = new Room();
        r.setRoomNumber(
           cleverCalculationWithFloorAndRoomNr(floor, room));
        hotelBuild[floor][room]= r;