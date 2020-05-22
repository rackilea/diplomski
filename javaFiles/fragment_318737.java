public class TreeSet<E> { ...
  public static <E extends Comparable<? super E>> TreeSet<E>
      create(Collection<? extends E> collection) {
    TreeSet<E> set = new TreeSet<E>();
    set.addAll(collection);
    return set;
  }
  ...
}