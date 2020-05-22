public interface Stack<E> {

      public boolean isEmpty();

      public E peek() throws EmptyStructureException;

      public E pop() throws EmptyStructureException;

      public void push(E target);

}