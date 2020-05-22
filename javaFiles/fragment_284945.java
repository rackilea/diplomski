public class Room {

    private int totalBeds;
    public final int priority;
    private ArrayList<Soldier> soldiers;

    public Room(int totalBeds, int priority) {
        this.totalBeds = totalBeds;
        this.priority = priority;
        soldiers = new ArrayList<>();
    }

    public boolean add(Solider s) {
        if(soldiers.size() >= totalBeds) {
            return false;
        }
        return soldiers.add(s);
    }

    public int getRemainingBeds() {
        return totalBeds - soldiers.size();
    }

    public boolean isFull() {
        return totalBeds <= soldiers.size();
    }
}