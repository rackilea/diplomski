public class TrackerNode {
    private int age;
    private String name;
    private TrackerNode nextNodeRef; // Reference to the next node

    public TrackerNode() {
        this("", 0);
    }

    public TrackerNode(String name, int age) {
        this(name, age, null);
    }

    public TrackerNode(String name, int age, TrackerNode nextLoc) {
        this.age = age;
        this.name = name;
        this.nextNodeRef = nextLoc;
    }

    public void insertAfter(TrackerNode nodeLoc) {
        TrackerNode tmpNext = this.nextNodeRef;
        this.nextNodeRef = nodeLoc;
        nodeLoc.nextNodeRef = tmpNext;
    }

    // Get location pointed by nextNodeRef
    public TrackerNode getNext() {
        return this.nextNodeRef;
    }

    @Override
    public String toString() {
        return String.format("%s, %d", this.name, this.age);
    }
}