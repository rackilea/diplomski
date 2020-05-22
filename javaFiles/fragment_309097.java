public abstract class AbstractSet<E> implements Set<E> {
   // we define the implementation for isEmpty by saying it means
   // size is 0
   public boolean isEmpty() { return this.size() == 0; }
   // let all the other methods be determined by the implementer
}