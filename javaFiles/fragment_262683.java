/**
 * Creates a {@link SortedList} wrapper of this list with the natural
 * ordering.
 * @return new {@code SortedList}
 * @since JavaFX 8.0
 */
public default SortedList<E> sorted() {
    Comparator naturalOrder = new Comparator<E>() {

        @Override
        public int compare(E o1, E o2) {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return -1;
            }
            if (o2 == null) {
                return 1;
            }

            if (o1 instanceof Comparable) {
                return ((Comparable) o1).compareTo(o2);
            }

            return Collator.getInstance().compare(o1.toString(), o2.toString());
        }
    };
    return sorted(naturalOrder);
}