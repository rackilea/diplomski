/**
 * Create an Iterator from multiple Iterators. The returned Iterator
 * traverses all elements from all sources, in the order, as if they belong
 * to the same source.
 * 
 * @param <T> type of elements
 * @param sources sources of the elements, in order of traversal
 * @return an iterator over multiple iterators in sequence
 */
public static <T> Iterator<T> concatenate(final Iterator<T> ... sources) {
    if (sources.length == 0) {
        return new Iterator<T>() {
            @Override public boolean hasNext() { return false; }
            @Override public T next() { throw new NoSuchElementException("end of iteration"); }
            @Override public void remove() { throw new IllegalStateException("no previous element"); }
        };
    }
    return new Iterator<T>() {

        Iterator<Iterator<T>> sourcesIterator = Arrays.asList(sources).iterator();
        Iterator<T> currentIterator = sourcesIterator.next();

        @Override
        public boolean hasNext() {
            if (currentIterator.hasNext()) {
                return true;
            } else {
                if (sourcesIterator.hasNext()) {
                    currentIterator = sourcesIterator.next();
                    return hasNext();
                } else {
                    return false;
                }
            }
        }

        @Override
        public T next() {
            if (hasNext()) {
                return currentIterator.next();
            } else {
                throw new NoSuchElementException("end of iteration");
            }
        }

        @Override
        public void remove() {
            currentIterator.remove();
        }
    };
}

/**
 * Create an Iterable from multiple Iterables. The returned Iterable
 * traverses all elements from all sources, in the order, as if they belong
 * to the same source.
 * 
 * @param <T> type of elements
 * @param sources sources of the elements, in order of traversal
 * @return an iterable over multiple iterators in sequence
 */
@SuppressWarnings("unchecked") // impossible to create a generic array
public static <T> Iterable<T> concatenate(final Iterable<T> ... sources) {
    return new Iterable<T>() {
        @Override
        public Iterator<T> iterator() {
            final Iterator[] iteratorsArrays = new Iterator[sources.length];
            for (int i = 0; i < sources.length; i++) {
                iteratorsArrays[i] = sources[i].iterator();
            }
            return concatenate(iteratorsArrays);
        }
    };
}