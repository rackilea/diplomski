public class MasterControlPanel {
    public static Room[] rooms = new Room[4];

    public static void main(String[] args) {

        rooms[0] = new Room("Room U", 1, 4, 4);
        rooms[1] = new Room("Room U", 2, 4, 4);
        rooms[2] = new Room("Connector X", 3, 2, 4);
        rooms[3] = new Room("Connector U", 4, 2, 4);

        for (int x = 0; x <= rooms.length-1; x++) {
            rooms[x].createLights();
            rooms[x].createWalls();
        }
    }

    public static Room retrieveRoom(int connectedRoom) {
        connectedRoom -= 1;
        return rooms[connectedRoom];
    }

}

class Room {
    // These are instance members for Room class
    private String roomString;
    private int roomInteger1, roomInteger2, roomInteger3;

    public Room(String string, int integer1, int integer2, int integer3) {
        // This is the constructor for Room object
        this.roomString = string;
        this.roomInteger1 = integer1;
        this.roomInteger2 = integer2;
        this.roomInteger3 = integer3;
    }

    public void createLights() {
        // This method creates lights
    }

    public void createWalls() {
        // This method creates walls
    }

    // These are Getters and Setters for Room members
    public String getRoomString() {
        return roomString;
    }

    public void setRoomString(String roomString) {
        this.roomString = roomString;
    }

    public int getRoomInteger1() {
        return roomInteger1;
    }

    public void setRoomInteger1(int roomInteger1) {
        this.roomInteger1 = roomInteger1;
    }

    public int getRoomInteger2() {
        return roomInteger2;
    }

    public void setRoomInteger2(int roomInteger2) {
        this.roomInteger2 = roomInteger2;
    }

    public int getRoomInteger3() {
        return roomInteger3;
    }

    public void setRoomInteger3(int roomInteger3) {
        this.roomInteger3 = roomInteger3;
    }
}