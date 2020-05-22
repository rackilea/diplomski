/**
 * @throws ClassCastException {@inheritDoc}
 * @throws NullPointerException if {@code fromElement} is null and
 *         this set uses natural ordering, or its comparator does
 *         not permit null elements
 * @throws IllegalArgumentException {@inheritDoc}
 * @since 1.6
 */
public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
    return new TreeSet<>(m.tailMap(fromElement, inclusive));
}