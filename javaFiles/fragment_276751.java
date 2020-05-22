abstract class Hierarchical<E extends Hierarchical> {
  protected final Map<String, E> children;

  public boolean query(Queue<String> query) {
    String key = query.poll();
    if(key != null) {
      E value = map.get(key);
      if(value != null) {
        return query.isEmpty() || value.contains(query);
      }
    }
    return false;
  }
}

class University extends Hierarchical<Major> {}

class Major extends Hierarchical<Student> {}

// special case for the bottom of the hierarchy
class Student extends Hierarchical<Hierarchical> {
  public Student() {
    children = null;
  }

  @Override
  public boolean query(Queue<String> query) {
    throw new UnsupportedOperationException("query should never reach this depth");
  }
}

class Main {
  // true if the path is valid, else false
  public boolean query(Hierarchial root, Queue<String> query) {
    return root.contains(query);
  }
}