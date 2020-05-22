class ManagedUser implements User {

    public void enterRoom(Room room) {
        //provide an ID of some sort to the room
        //particular to ManagedUser world
        room.enter(myID);
    }
}