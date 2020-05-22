public class Building{

public static Rooms roomArray[] = new Rooms[4];
private float outsideTemp;
List<Room> rooms;

public Building(float temp){
    rooms = new ArrayList<Room>();
    rooms.add(new Room()); 
    rooms.add(new Room());
    outsideTemp = temp;
}

public List<Rooms> getRoomList() {
    return this.rooms;
}
}