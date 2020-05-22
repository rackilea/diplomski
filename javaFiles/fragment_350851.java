public class MyVertex {
  public String colour;
}

SimpleGraph<MyVertex, DefaultEdge> g = 
    new SimpleGraph<MyVertex,DefaultEdge>(DefaultEdge.class);
MyVertex v1 = new MyVertex();
MyVertex v2 = new MyVertex();

g.addVertex(v1);
g.addVertex(v2);

DefaultEdge edge = g.addEdge(v1, v2);

//traverse graph
Graphs.getOppositeVertex(g, edge, v1).colour = "red";