public class VertexSet {
  private TreeMap<Location, Vertex> treeMap; //todo: instantiate w/ comparator in constructor

  public void add(Vertex v){
    treeMap.putIfAbsent(v.getLocation(), v);
  }

 public Vertex pop() {
    treeMap.get(treeMap.firstKey());  
  }
}