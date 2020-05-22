public class Room {

    private Map<Direction, Room> exits;

    public Room(){
        this.exits = new HashMap<>();
    }

    public void setExit(Direction direction, Room room){
        this.exits.put(direction, room);
    }

    public Room getExit(Direction direction){
        return this.exits.get(direction);
    }
}