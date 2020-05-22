public class IteratorColValueDecorator implements Iterator<ColValue> {
      private Iterator<HColumn<ColName, ColValue>> original;
      //constructor taking the original iterator
      public ColValue next() {
           return original.next().getValue();
      }
      //others simply delegating
}