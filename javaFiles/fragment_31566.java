public class TreeBag<T> implements Bag<T> {
    private final Comparator<? super T> comparator;

    public TreeBag(Comparator<? super T> comparator) {
        this.comparator = Objects.requireNonNull(comparator, "comparator");
    }

    /// and somewhere 
   void somewhere() {
       T o1 = ....;
       T o2 = ....;

      int rc = comparator.compare(o1, o2);
      if (rc < 0) {
      } else if (rc > 0) {
      } else {
      }  
   }
}