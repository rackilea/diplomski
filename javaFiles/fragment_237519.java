public class SortedArrayList<E> extends ForwardingList<E> implements
    RandomAccess{

    private final class ListIteratorImpl extends ForwardingListIterator<E>{
        private final int start;
        public ListIteratorImpl(final int start){
            this.start = start;
        }

        @Override
        public void set(E element){throw new UnsupportedOperationException();}

        @Override
        public void add(E element){throw new UnsupportedOperationException();}

        @Override
        protected ListIterator<E> delegate(){return inner.listIterator(start);};

    }

    private Comparator<? super E> comparator;

    private List<E> inner;

    public SortedArrayList(){this(null, null, null);}

    @SuppressWarnings("unchecked")
    private SortedArrayList(
        final List<E> existing,
        final Collection<? extends E> values,
        final Comparator<? super E> comparator
    ){
        this.comparator =
            (Comparator<? super E>)
               (comparator == null
                   ? Ordering.natural()
                   : comparator   );
        inner = (
            existing == null
                ? (values == null
                      ? new ArrayList<E>(values)
                      : new ArrayList<E>()
                   )
                : existing;
    }

    public SortedArrayList(final Collection<? extends E> c){
        this(null, c, null);
    }

    public SortedArrayList(final Collection<? extends E> c,
        final Comparator<? super E> comparator){
        this(null, c, comparator);
    }

    public SortedArrayList(final Comparator<? super E> comparator){
        this(null, null, comparator);
    }

    public SortedArrayList(final int initialCapacity){
        this(new ArrayList<E>(initialCapacity), null, null);
    }

    public SortedArrayList(final int initialCapacity,
        final Comparator<? super E> comparator){
        this(new ArrayList<E>(initialCapacity), null, comparator);
    }

    @Override
    public boolean add(final E e){
        inner.add(
            Math.abs(
                Collections.binarySearch(inner, e, comparator)
            ) + 1,
            e
        );
        return true;
    }

    @Override
    public void add(int i, E e){throw new UnsupportedOperationException();}

    @Override
    public boolean addAll(final Collection<? extends E> collection){
        return standardAddAll(collection);
    }

    @Override
    public boolean addAll(int i,
        Collection<? extends E> es){
        throw new UnsupportedOperationException();
    }

    @Override
    protected List<E> delegate(){ return inner; }

    @Override
    public List<E> subList(final int fromIndex, final int toIndex){
        return new SortedArrayList<E>(
            inner.subList(fromIndex, toIndex),
            null,
            comparator
        );
    }

    @Override
    public ListIterator<E> listIterator(){ return new ListIteratorImpl(0); }

    @Override
    public ListIterator<E> listIterator(final int index){
        return new ListIteratorImpl(index);
    }

    @Override
    public E set(int i, E e){ throw new UnsupportedOperationException(); }

}