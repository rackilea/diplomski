import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class UndirectedGraph {
  private Vector<List<Integer>> edges;
  private int vertexCount = 0;

  public UndirectedGraph(int vertexCount) {
    this.vertexCount = vertexCount;
    edges = new Vector<List<Integer>>(vertexCount);
    for (int i = 0; i < vertexCount; i++){
      edges.addElement(new LinkedList<Integer>());
    }
  }

  public void addEdge(int u, int v) {
    edges.get(u).add(v);
    edges.get(v).add(u);
  }

  public int getNumberVertices() {
    return vertexCount;
  }

  public Object getAdjacentVertices(int u) {
    return edges.get(u);
  }

    public static void main(String [] args) {
    UndirectedGraph g = new UndirectedGraph(4);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(1, 3);
    g.addEdge(2, 3);

    for (int i = 0; i < g.getNumberVertices(); i++) {
      System.out.println("Neighbors of node " + i + ": " + g.getAdjacentVertices(i));
    }
  }
}