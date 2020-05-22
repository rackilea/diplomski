public class SetList<V> implements Set<V>, List<V> {
    @Override
    public Spliterator<V> spliterator() {
        return List.super.spliterator();
    }
}