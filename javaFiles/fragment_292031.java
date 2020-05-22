public class Road {

    private int floorsOfBuilding;
    private int windowsInBuilding;
    private int climbTime;
    private int crossingTime;

    // Constructor
    public Road(int floorsOfBuilding, int windowsInBuilding, int climbTime, int crossingTime) {
        this.floorsOfBuilding = floorsOfBuilding;
        this.windowsInBuilding = windowsInBuilding;
        this.climbTime = climbTime;
        this.crossingTime = crossingTime;
        // You can do simple calculations here but for more complex it is better
        // to create a method to maintain readability
    }

    public String toString() {
        return "\n" + floorsOfBuilding + " " + windowsInBuilding + "  " + climbTime + "  " + crossingTime;
    }
}