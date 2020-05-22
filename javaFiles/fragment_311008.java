import java.util.Iterator;

/**Alternates on the given iterators.*/
public class AlternatingIterator<E> implements Iterator {

    /**Stores the iterators which are to be alternated on.*/
    private Iterator<E>[] iterators;

    /**The index of iterator, which has the next element.*/
    private int nextIterator = 0;

    /**Initializes a new AlternatingIterator object.
     * Stores the iterators in the iterators field.
     * Finds the first iterator with an available element.*/
    public AlternatingIterator(Iterator<E> ... iterators) {
        this.iterators = iterators;

        if (!iterators[0].hasNext())
            findNextIterator();
    }

    @Override
    public boolean hasNext() {
        return iterators[nextIterator].hasNext();
    }

    @Override
    public Object next() {
        E element = iterators[nextIterator].next();

        findNextIterator();

        return element;
    }

    /**Steps on iterators, until one has next element.
     * It does not step on them infinitely, stops when
     * the lastly used iterator is reached.*/
    private void findNextIterator() {
        int currentIterator = nextIterator;

        // Finding iterator with element remaining.
        do {
            stepNextIterator();
        } while (!iterators[nextIterator].hasNext() && nextIterator != currentIterator);
        // If it gets around to the same iterator, then there is no iterator with element.
    }

    /**Increases the nextIterator value without indexing out of bounds.*/
    private void stepNextIterator() {
        nextIterator = (nextIterator + 1) % iterators.length;
    }

}