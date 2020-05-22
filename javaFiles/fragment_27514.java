public HotelRoom copy() {
    Room newRoom = new Room();
    newRoom.member0 = this.member0;
    ...
    newRoom.membern = this.membern;
    return newRoom;
}