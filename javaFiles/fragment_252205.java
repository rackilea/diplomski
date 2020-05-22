for (Room room : occupiedRooms)
{
    if(room.getRoomNo().equals(roomNo))
        return room;
    getGuest();
    return "room " + roomNo + " is not occupied" ;
}