public class ArrayIterator<E> implements Iterator<E>{

    private E[] elements;
    private int index;

    public ArrayIterator(E[] elements){
        this.elements = elements;
        index = 0;
    }

    @Override
    public boolean hasNext(){
        return index < elements.length;
    }

    @Override
    public E next(){
        if(!hasNext()){
            throw new NoSuchElementException("No more elements in the array.");
        }
        return elements[index++];
    }

    @Override
    public void remove(){
        throw new UnsupportedOperationException("Remove operation is not supported.");
    }

}