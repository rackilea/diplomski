/**
 * Constructs a new, empty tree set, sorted according to the
 * natural ordering of its elements.  All elements inserted into
 * the set must implement the {@link Comparable} interface.
 * Furthermore, all such elements must be <i>mutually
 * comparable</i>: {@code e1.compareTo(e2)} must not throw a
 * {@code ClassCastException} for any elements {@code e1} and
 * {@code e2} in the set.  If the user attempts to add an element
 * to the set that violates this constraint (for example, the user
 * attempts to add a string element to a set whose elements are
 * integers), the {@code add} call will throw a
 * {@code ClassCastException}.
 */
public TreeSet() {
    this(new TreeMap<E,Object>());
}