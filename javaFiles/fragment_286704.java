class ExampleTest {
  Map<Integer, Set<Integer>> graph;  

  static public void main(String[] args) {
    ExampleTest x=new ExampleTest();
    x.graph=new HashMap<>();
    x.graph.put(1, new HashSet<>(Arrays.asList(2)));
    x.graph.put(2, new HashSet<>(Arrays.asList(3)));
    x.graph.put(3, new HashSet<>(Arrays.asList(4)));
    x.graph.put(4, new HashSet<>(Arrays.asList(5)));
    x.graph.put(5, new HashSet<>(Arrays.asList(6)));
    System.out.println(x.checkLevelBFS(1, 2)); // true
    System.out.println(x.checkLevelBFS(1, 3)); // true
    System.out.println(x.checkLevelBFS(1, 4)); // true
    System.out.println(x.checkLevelBFS(1, 5)); // true
    System.out.println(x.checkLevelBFS(1, 6)); // false
  }

  // verbatim copy of your method here
  public boolean checkLevelBFS(Integer source, Integer dest) {
    Queue<Integer> toVisitQueue = new LinkedList<>(graph.get(source));
    Set<Integer> visited = new HashSet<>();
    visited.add(source);
    Integer inreaser = new Integer(-1); // indicator for level increase
    toVisitQueue.add(inreaser);
    int level = 1; // because we already passed the source and started from its children nodes
    while (level <= 4 && !toVisitQueue.isEmpty()) {
      Integer currentNode = toVisitQueue.remove();
      if (currentNode.equals(dest)) {
        return true;
      }
      if (visited.contains(currentNode)) {
        continue;
      }
      if (currentNode.equals(inreaser)) {
        level++;
        toVisitQueue.add(inreaser);
        continue;
      }
      visited.add(currentNode);
      for (Integer child : graph.get(currentNode)) {
        if (!visited.contains(child)){
          toVisitQueue.add(child);
        }
      }
    }
    return false;
  }

}