@JsonSerialize(using = RoomSerializer.class)
public class Room<T> {
    private int roomId;
    private String roomName;
    private T roomDetails;

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public T getRoomDetails() {
        return roomDetails;
    }

    public void setRoomDetails(T roomDetails) {
        this.roomDetails = roomDetails;
    }
}