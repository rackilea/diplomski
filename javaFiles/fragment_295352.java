public class Building implements Comparable<Building> {
    //render, constructor, etc.
    public int compareTo(Building b) {
        return b.y - y;
        //sort buildings based on their distance from the bottom of the world
    }
}