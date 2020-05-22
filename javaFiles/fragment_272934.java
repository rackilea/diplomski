public class GraphNode {
    /*Global Variables*/
    boolean visited;
    List<GraphNode> nodeNeighbours;
    /*Global Variables*/

    public GraphNode() {
        this.nodeNeighbours = new ArrayList<GraphNode>();  // store neighbors
        this.visited = false;

    }

    public void addNeighbor(GraphNode target) {
        this.nodeNeighbours.add(target);    //This will add target to the neighbours of this given node.
    }
}