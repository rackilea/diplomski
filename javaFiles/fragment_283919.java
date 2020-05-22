public class ArrayListSorted<E extends Comparable<E>> extends AbstractArrayMyList<E> {
     private static final int DEFAULT_CAPACITY = 100; 

     public ArrayListSorted(){
         this(DEFAULT_CAPACITY);
     }

     @SuppressWarnings("unchecked")
    public ArrayListSorted(int initialSize){
           //call parent constructor passing in new array
        super((E[]) new Comparable[initialSize]);
    }

...