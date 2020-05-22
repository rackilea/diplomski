public class Partitioner<E> implements Iterator<List<E>> {

    private final Iterator<E> iterator;
    private final int partitionSize;

    public static <T> Stream<List<T>> partition(final Stream<T> stream, final int partitionSize) {
        return new Partitioner<>(stream, partitionSize).asStream();
    }

    public Partitioner(final Stream<E> stream, final int partitionSize) {
        this(stream.iterator(), partitionSize);
    }

    public Partitioner(final Iterator<E> iterator, final int partitionSize) {
        this.iterator = iterator;
        this.partitionSize = partitionSize;
    }

    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override
    public List<E> next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements");
        }
        final ArrayList<E> result = new ArrayList<>(this.partitionSize);
        for (int i = 0; i < this.partitionSize && hasNext(); i++) {
            result.add(this.iterator.next());
        }
        return result;
    }

    public Stream<List<E>> asStream() {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(this, Spliterator.NONNULL), false);
    }

}