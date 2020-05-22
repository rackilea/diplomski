package langGenerics;

import java.util.HashSet;
import java.util.Set;

public class UseGenerics {
  public static void main(String[] args) {
    SetFactory<Integer> setFactory = HashSet::new;
    DisjointSet<Integer> disjointSet = new DisjointSet<>(setFactory);
    disjointSet.doSomething( 123 );
  }
}

interface SetFactory<T> { Set<T> get(); }

class DisjointSet<T> {
  private SetFactory<T> setFactory;
  public DisjointSet(SetFactory<T> setFactory) {
    this.setFactory = setFactory;
  }
  public void doSomething(T item) {
      Set<T> set = setFactory.get();
      set.add(item);
  }
}