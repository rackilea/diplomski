void link(Room room, Point point) {
    Room oldRoom = point.getRoom();
    if (oldRoom!=null) oldRoom.removePoint(point);
    room.addPoint(point);
    point.setRoom(room);
}