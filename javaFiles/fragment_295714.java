public class IteratorOfIterator<T> implements Iterator<T> {

private Iterator<T>[] iterators;

private Iterator<T> currentIterator;

private int currentIndex;

public IteratorOfIterator(Iterator<T>[] iterators){
    this.iterators = iterators;
    this.currentIndex = 0;
    this.currentIterator = iterators[currentIndex];
}