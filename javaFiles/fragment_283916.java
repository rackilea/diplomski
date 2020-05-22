public abstract class AbstractArrayMyList<E extends Comparable<E>> implements List<E>  {

    ...

    public AbstractArrayMyList( int capacity) {
         elementData = (E[]) new Comparable[capacity];
   }

   ...