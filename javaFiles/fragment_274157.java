import java.util.ArrayList;
import java.util.LinkedHashMap;

public class HotelRooms {

    LinkedHashMap<String, Room> roomMap = new LinkedHashMap<String, Room>();

    public class Room {
        private String roomName;
        private String roomType;
        private int roomNumSeat;
        private int status;

        public Room(String roomName, String roomType, int roomSeat,
                int roomStatus) {
            this.roomName = roomName;
            this.roomType = roomType;
            this.roomNumSeat = roomSeat;
            this.status = roomStatus;
        }

    }

    public class Guest {
        private String guestID;
        private String guestName;
        private double time;
        private int guestNum;
        private double bonus;
        private ArrayList<String> guestServices = new ArrayList<String>();
        private ArrayList<String> guestRoomType = new ArrayList<String>();
        private Room room;
        private Services services;

        public Guest(String guestID, String guestName, double time,
                int guestNum, double bonus, ArrayList<String> guestServices,
                ArrayList<String> guestRoomType) {
            this.guestID = guestID;
            this.guestName = guestName;
            this.time = time;
            this.guestNum = guestNum;
            this.bonus = bonus;
            this.guestServices = guestServices;
            this.guestRoomType = guestRoomType;
        }

    }

    public void createRooms(String roomName, String roomType, int roomSeat,
            int roomStatus) {
        Room room = new Room(roomName, roomType, roomSeat, roomStatus);
        roomMap.put(roomName, room);
    }

    public String roomForGuest() {
        Guest g = new Guest("1234", "taki", 12.00, 2, 0, null, null);
        String roomName = this.getRoom(g);
        System.out.println(roomName);
        return roomName;
    }

    public String getRoom(Guest g) {
        Room roomObj = null;
        String roomName = "";
        int firstValue, previousValue = 0, count = 0;
        for (String key : roomMap.keySet()) {
            roomObj = roomMap.get(key);
            firstValue = roomObj.roomNumSeat - g.guestNum;
            if ((firstValue >= 0 && firstValue <= previousValue) || count == 0
                    || previousValue < 0)
                roomName = roomObj.roomName;
            previousValue = firstValue;
            count++;
        }
        return roomName;
    }

    public static void main(String[] args) {
        HotelRooms test = new HotelRooms();
        test.createRooms("A1001", "", 2, 0);
        test.createRooms("A1002", "", 6, 0);
        test.createRooms("A1003", "", 8, 0);
        test.roomForGuest();
    }

}