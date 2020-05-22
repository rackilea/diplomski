public class Node {
    private int id;
    private List<Node> adjacentNodes = new ArrayList<Node>();

    public List<Node> getAdjacentNodes() {
        return adjacentNodes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}