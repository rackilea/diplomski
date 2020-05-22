class Tuple {

  int x1, x2, y1, y2;

  public Tuple(int x1, int y1, int x2, int y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }

  boolean isDirectlyConnectedWith(Tuple tuple) {
    return (this.x1 == tuple.x1 && this.y1 == tuple.y1)
        || (this.x2 == tuple.x2 && this.y2 == tuple.y2)
        || (this.x1 == tuple.x2 && this.y1 == tuple.y2)
        || (this.x2 == tuple.x1 && this.y2 == tuple.y1);
  }
}

public class Main {

  public static void main(String args[]){

    Set<Tuple> tuples = new HashSet<>();
    Tuple tuple1 = new Tuple(1,1,2,2);
    Tuple tuple2 = new Tuple(1,1,4,5);
    Tuple tuple3 = new Tuple(4,5,2,3);
    Tuple tuple4 = new Tuple(5,6,7,8);
    tuples.addAll(Arrays.asList(tuple1, tuple2, tuple3, tuple4));

    System.out.println("Tuples 1 and 3 are connected: " + areTuplesConnected(tuples, tuple1, tuple3));
    System.out.println("Tuples 1 and 4 are connected: " + areTuplesConnected(tuples, tuple1, tuple4));
  }

  static boolean areTuplesConnected(Set<Tuple> tuples, Tuple t1, Tuple t2) {
    LinkedList<Tuple> stack = new LinkedList<>();
    stack.addLast(t1);
    return processSearchStep(tuples, stack, t2);
  }

  static boolean processSearchStep(Collection<Tuple> allTuples, LinkedList<Tuple> currentStack, Tuple targetTuple) {
    Set<Tuple> possibleNextTuples = allTuples.stream()
        .filter(t -> !currentStack.contains(t) && t.isDirectlyConnectedWith(currentStack.getLast()))
        .collect(Collectors.toSet());
    for (Tuple nextTuple : possibleNextTuples) {
      currentStack.addLast(nextTuple);
      if (nextTuple.equals(targetTuple)) {
        return true;
      }
      if (processSearchStep(allTuples, currentStack, targetTuple)) {
        return true;
      }
      currentStack.removeLast();
    }
    return false;
  }

}