public class House {

    private final String name;
    private PriorityQueue<Room> rooms;

    public House(String name, Room... rooms) {
        this.name = name;
        this.rooms = new PriorityQueue<>(new Comparator<Room>() {
            public int compare(Room a, Room b) {

                //Always prioritize an open room to a full one
                if(a.isFull() && b.isFull()) {
                    return 0;
                } else if (a.isFull()) {
                    return 1;
                } else if (b.isFull()) {
                    return -1;
                } else {
                    //Now try to get the room with the most available rooms
                    int bedDiff = b.getRemainingBeds() - a.getRemainingBeds();
                    if(bedDiff != 0) {
                        return bedDiff;
                    }
                    return a.priority - b.priority;
                }
           }
       });
       for(Room r : rooms) {
           this.rooms.add(r)
       }
    }

    public boolean add(Soldier s) {
        Room r = rooms.poll();
        boolean ok = r.add(s);
        rooms.add(r);
        return ok;
    }

    public String getName() {
        return name;
    }
}