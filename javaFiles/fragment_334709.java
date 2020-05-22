class MyArraySpliterator implements Spliterator.OfInt {
    final int[] intArray;
    int pos;
    final int end;
    final Comparator<? super Integer> comp;

    MyArraySpliterator(int[] array, Comparator<? super Integer> c) {
        this(array, 0, array.length, c);
    }
    MyArraySpliterator(int[] array, int s, int e, Comparator<? super Integer> c) {
        intArray=array;
        pos=s;
        end=e;
        comp=c;
    }
    @Override
    public OfInt trySplit() {
        if(end-pos<64) return null;
        int mid=(pos+end)>>>1;
        return new MyArraySpliterator(intArray, pos, pos=mid, comp);
    }
    @Override
    public boolean tryAdvance(IntConsumer action) {
        Objects.requireNonNull(action);
        if(pos<end) {
            action.accept(intArray[pos++]);
            return true;
        }
        return false;
    }
    @Override
    public boolean tryAdvance(Consumer<? super Integer> action) {
        Objects.requireNonNull(action);
        if(pos<end) {
            action.accept(intArray[pos++]);
            return true;
        }
        return false;
    }
    @Override
    public long estimateSize() {
        return end-pos;
    }
    @Override
    public int characteristics() {
        return SIZED|SUBSIZED|SORTED|ORDERED|NONNULL;
    }
    @Override
    public Comparator<? super Integer> getComparator() {
        return comp;
    }
}