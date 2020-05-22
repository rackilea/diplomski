public class GraphNode {
    /*Global Variables*/
    protected double weight;
    protected double distanceFromRoot;
    protected List<GraphNode> neighbours;
    protected boolean visited;
    /*Global Variables*/

    public GraphNode(double weight, double distanceFromRoot) {
        this.weight = weight;
        this.distanceFromRoot = distanceFromRoot;
        this.neighbours = new ArrayList<GraphNode>();
        this.visited = false;
    }

    public void setDistanceFromRoot(double distanceFromRoot) {
         this.distanceFromRoot = distanceFromRoot;
    }

    public void setVisited(boolean visited) {
         this.visited = visited;
    }

    public double getWeight() {
        return this.weight;
    }

    public double getDistanceFromRoot() {
        return this.distanceFromRoot;
    }

    public List<GraphNode> getNeighbours() {
        return this.neighbours;
    }   

    public void addNeighbour(GraphNode neighbour) {
        this.neighbours.add(neighbour)
    }
}